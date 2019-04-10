/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeBuilder;

import Smarty.*;
import java.util.ArrayList;
import java.util.List;
import Pact.*;
import Utils.*;
import java.util.LinkedHashMap;

/**
 *
 * @author KonnerEL
 */
public class Transpiler extends SmartyBaseListener{
    String Program;
    List<String>Entity;
    List<List<String>>EntityAttributes;
    List<List<String>>EntityTypes;
    List<String>Custom_Events;
    List<String>Create_Events;
    List<List<String>>Custom_EventsParameters;
    List<List<String>>Create_EventsParameters;
    List<List<String>>RelationatedEntities;
    List<List<Precondition>>Preconditions;
    List<List<Action>>Actions;
    List<List<Invariant>>Invariants;
    List<String>Invoked_Events;
    List<List<String>>Events_Values;
    
    public Transpiler() {
        Program = "";
        Entity = new ArrayList<>();
        EntityAttributes = new ArrayList<>();
        EntityTypes = new ArrayList<>();
        Custom_Events = new ArrayList<>();
        Create_Events = new ArrayList<>();
        Custom_EventsParameters = new ArrayList<>();
        Create_EventsParameters = new ArrayList<>();
        RelationatedEntities = new ArrayList<>();
        Preconditions = new ArrayList<>();
        Actions = new ArrayList<>();
        Invariants = new ArrayList<>();
        Invoked_Events = new ArrayList<>();
        Events_Values = new ArrayList<>();
    }
    
    @Override
    public void exitEntity(SmartyParser.EntityContext ctx) {
        Entity.add(ctx.Identifier().getText());
    }

    @Override
    public void exitField(SmartyParser.FieldContext ctx) {
        ArrayList<String>Identifiers = new ArrayList<>();
        ArrayList<String>Types = new ArrayList<>();
        ctx.Identifier().forEach(attribute -> Identifiers.add(attribute.getText()));
        EntityAttributes.add(Identifiers);
        ctx.Type().forEach(type -> Types.add(type.getText()));
        EntityTypes.add(Types);
    }

    @Override
    public void exitCustom_event(SmartyParser.Custom_eventContext ctx) {
        Custom_Events.add(ctx.Identifier().getText());
        ArrayList<String>Params = new ArrayList<>();
        ctx.argument().Identifier().forEach(arg -> Params.add(arg.getText()));
        Custom_EventsParameters.add(Params);
        List<String>Subjs = new ArrayList<>();
        ctx.entities().subjects().Identifier().forEach(subject -> Subjs.add(subject.getText()));
        RelationatedEntities.add(Subjs);
        List<Precondition>Precs = new ArrayList<>();
        ctx.precondition().forEach(pre -> {
            String left_Side = pre.condition().left_Side().getText();
            String Operator = pre.condition().Logic_Operator().getText();
            String right_Side = pre.condition().right_Side().getText();
            String Exception = pre.exceptionHandler().StringLiteral().getText();
            Precs.add(new Precondition(left_Side, Operator, right_Side, Exception));
        });
        Preconditions.add(Precs);
        List<Action>Acts = new ArrayList<>();
        ctx.action().forEach(action -> {
            String left_Side = action.statement().left_Side().getText();
            String Operator = ":=";
            String right_Side = "";
            for (int i = 0; i < action.statement().right_Side().size(); i++) {
                if (i > 0) right_Side = right_Side + action.statement().Arithmetic_Operator(i - 1).getText();
                right_Side = right_Side + action.statement().right_Side(i).getText();
                
            }
            Acts.add(new Action(left_Side, Operator, right_Side));
        });
        Actions.add(Acts);
    }

    @Override
    public void exitInsert_object(SmartyParser.Insert_objectContext ctx) {
        Create_Events.add("create_" + ctx.Identifier().getText());
        ArrayList<String>Params = new ArrayList<>();
        ctx.argument().Identifier().forEach(arg -> Params.add(arg.getText()));
        Create_EventsParameters.add(Params);
        List<Invariant>Invs = new ArrayList<>();
        ctx.invariant().forEach(inv -> {
            String left_Side = inv.condition().left_Side().getText();
            String Operator = inv.condition().Logic_Operator().getText();
            String right_Side = inv.condition().right_Side().getText();
            String Exception = inv.StringLiteral().getText();
            Invs.add(new Invariant(left_Side, Operator, right_Side, Exception));
        });
        Invariants.add(Invs);
    }

    /*@Override
    public void exitGet_info(SmartyParser.Get_infoContext ctx) {
        Events.add("get_info");
        ArrayList<String>Params = new ArrayList<>();
        ctx.argument().Identifier().forEach(arg -> Params.add(arg.getText()));
        EventsParameters.add(Params);
        List<String>Subjs = new ArrayList<>();
        ctx.subjects().Identifier().forEach(subject -> Subjs.add(subject.getText()));
        RelationatedEntities.add(Subjs);
    }*/
    
    @Override
    public void exitInvoke(SmartyParser.InvokeContext ctx) {
        Invoked_Events.add(ctx.Identifier().getText());
        List<String>Values = new ArrayList<>();
        if (ctx.value().size() > 0) {
            ctx.value().forEach(val -> {
                if (val.Identifier() != null) Values.add("\"" + val.getText() + "\"");               
                else Values.add(val.getText());
            });
        }
        if (ctx.invocation_argument() != null) {
            ctx.invocation_argument().value().forEach(val -> {
                if (val.Identifier() != null) Values.add("\"" + val.getText() + "\"");               
                else Values.add(val.getText());
            });
        }
        Events_Values.add(Values);
    }
    
    public void buildPactSintax() {
        PactStructure Struc = new PactStructure("admin-keyset");
        PactModule Module = new PactModule("contract", "admin-keyset");
        Program = Struc.Compile();
        String Lisp_Functions = "";
        for (int i = 0; i < Create_Events.size(); i++) {
            Lisp_Functions += processCreate_Events(Create_Events.get(i), Create_EventsParameters.get(i), Invariants.get(i));              
        }
        Lisp_Functions += "\n\n";
        for (int i = 0; i < Custom_Events.size(); i++) {
            Lisp_Functions += processCustom_Events(Custom_Events.get(i), Custom_EventsParameters.get(i), RelationatedEntities.get(i), Preconditions.get(i), Actions.get(i));
        }
        Program += "\n" + Module.Compile(processSchemas(), processTables(), Lisp_Functions) + "\n\n";
        String createTables = "";
        for (int i = 0; i < Entity.size(); i++) {
            createTables += "(create-table " + Entity.get(i) + "_table" + ")" + "\n";
        }
        Program += createTables + processInvokes();
    }

    public String processSchemas() {
        String Schemas = "";
        for (int i = 0; i < Entity.size(); i++) {
            LinkedHashMap<String,String>Attributes = new LinkedHashMap();
            for (int j = 1; j < EntityAttributes.get(i).size(); j++) {
                Attributes.put(EntityAttributes.get(i).get(j), EntityTypes.get(i).get(j));
                //System.out.println(EntityAttributes.get(i).get(j));
            }
            Schemas += new PactSchema(Entity.get(i), Attributes).Compile() + "\n\n" ;
        }
        return Schemas;
    }
    
    public String processTables() {
        String Tables = "";
        for (int i = 0; i < Entity.size(); i++) {
            Tables += new PactTable(Entity.get(i)).Compile() + "\n\n";
        }
        return Tables;
    }
    
    public String processCustom_Events(String Event, List<String>Args, List<String>Entities, List<Precondition>Precs, List<Action>Acts) {
        if (Entities.size() == 1) {
            Entities.add(Entities.get(0));
        } 
        List<String>Lisp_Reads = new ArrayList<>();
        List<String>Lisp_Updates = new ArrayList<>();
        List<String>Lisp_Preconditions = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String Attributes = "{";
            String Attributes2 = "{";
            for (int j = 0; j < Acts.size(); j++) {
                if (Acts.get(j).getLeft_Side().contains(Args.get(i))) {
                    String Aux = Acts.get(j).getLeft_Side().substring(Acts.get(j).getLeft_Side().lastIndexOf(".") + 1);
                    Attributes = Attributes + "\"" + Aux + "\"";
                    Attributes2 = Attributes2 + "\"" + Aux + "\"";
                    Attributes = Attributes + " := " + Args.get(j) + "_" + Aux;
                    Attributes = Attributes + ",";
                    Aux = Args.get(j) + "_" + Aux;
                    String currentAction = Acts.get(j).toString().replace(Acts.get(i).getLeft_Side(), Aux);
                    currentAction = currentAction.substring(currentAction.indexOf("=") + 2, currentAction.length());
                    if (Recursive.getIndexOfOperator(currentAction, i) == currentAction.length()) {
                        //System.out.println(currentAction);
                        Attributes2 = Attributes2 + ": " + currentAction;
                    } else {
                        Attributes2 = Attributes2 + ": " + Recursive.convertToLispExpression(currentAction, 0, "");
                        //System.out.println(Recursive.convertToLispExpression(currentAction, 0, ""));
                    }
                    Attributes2 = Attributes2 + ",";
                }
            }
            Attributes = Attributes.substring(0, Attributes.lastIndexOf(","));
            Attributes2 = Attributes2.substring(0, Attributes2.lastIndexOf(","));
            Attributes = Attributes + " }";
            Attributes2 = Attributes2 + " }";
            PactAtom PR = new PactAtom(Entities.get(i) + "_table " + Args.get(i) + " " + Attributes, "");
            if (i == 0) PR.setIndentation(3);
            else PR.setIndentation(4);
            PR.chooseCoreFunction(2);
            //String Compile = PR.Compile();
            //System.out.println(Compile);
            Lisp_Reads.add(PR.Compile());
            PactAtom PU = new PactAtom(Entities.get(i) + "_table " + Args.get(i), Attributes2);
            PU.setIndentation(5);
            PU.chooseCoreFunction(3);
            Lisp_Updates.add(PU.Compile());
        }
        for (int i = 0; i < Precs.size(); i++) {
            //String Attribute = Precs.get(i).toString();
            //System.out.println(Attribute);
            String Aux = "";
            if (Precs.get(i).getLeft_Side().contains(".")) {
                int index = Precs.get(i).getLeft_Side().lastIndexOf(".");
                Aux = Precs.get(i).getLeft_Side().substring(0, index);
                Aux = Aux + "_" + Precs.get(i).getLeft_Side().substring(index + 1);
            } else {
                Aux = Precs.get(i).getLeft_Side();
            }
            Aux = Aux + Precs.get(i).getOperator();
            String Split[] = Precs.get(i).getRight_Side().split(" ");
            for (int j = 0; j < Split.length; j++) {
                if (Split[j].contains(".") && !TypeInference.CheckType(Split[j]).equals("isDecimal")) {
                    int index = Split[j].indexOf(".");
                    String Aux2 = Split[j].substring(0, index);
                    Aux2 = Aux2 + "_" + Split[j].substring(index + 1);
                    Aux = Aux + Aux2;
                } else {
                    Aux = Aux + Split[j];
                }
            }
            String precondition = Recursive.convertToLispExpression(Aux, 0, "");
            String exception = Precs.get(i).getException();
            PactAtom PA = new PactAtom(precondition, exception);
            PA.setIndentation(5);
            PA.chooseCoreFunction(5);
            Lisp_Preconditions.add(PA.Compile());
        }
        //System.out.println(String.join("\n", Lisp_Preconditions));
        //System.out.println(String.join("\n", Lisp_Updates));
        String output = "";
        output = output + Lisp_Reads.get(0);
        output = Parenthesis.insertBeforeFirstClosedParenthesis(output, Lisp_Reads.get(1));
        output = Parenthesis.insertBeforeFirstClosedParenthesis(output, String.join("\n", Lisp_Preconditions) + "\n" + String.join("\n", Lisp_Updates));
        PactFunction PF = new PactFunction(Event, Args, output);
        
        return PF.Compile();
    }
    
    public String processCreate_Events(String Event, List<String>Args, List<Invariant>Invs) {
        List<String>Lisp_Invariants = new ArrayList<>();
        if (Invs.size() > 0) {
            for (int i = 0; i < Invs.size(); i++) {
                //String Attribute = Precs.get(i).toString();
                //System.out.println(Attribute);
                String Aux = "";
                if (Invs.get(i).getLeft_Side().contains(".")) {
                    int index = Invs.get(i).getLeft_Side().lastIndexOf(".");
                    Aux = Invs.get(i).getLeft_Side().substring(0, index);
                    Aux = Aux + "_" + Invs.get(i).getLeft_Side().substring(index + 1);
                } else {
                    Aux = Invs.get(i).getLeft_Side();
                }
                Aux = Aux + Invs.get(i).getOperator();
                String Split[] = Invs.get(i).getRight_Side().split(" ");
                for (int j = 0; j < Split.length; j++) {
                    if (Split[j].contains(".") && !TypeInference.CheckType(Split[j]).equals("isDecimal")) {
                        int index = Split[j].indexOf(".");
                        String Aux2 = Split[j].substring(0, index);
                        Aux2 = Aux2 + "_" + Split[j].substring(index + 1);
                        Aux = Aux + Aux2;
                    } else {
                        Aux = Aux + Split[j];
                    }
                }
                String invariant = Recursive.convertToLispExpression(Aux, 0, "");
                String exception = Invs.get(i).getException();
                PactAtom PA = new PactAtom(invariant, exception);
                PA.setIndentation(2);
                PA.chooseCoreFunction(5);
                Lisp_Invariants.add(PA.Compile());
            }    
        }
        String searchEntity = Event.substring(Event.indexOf("_") + 1);
        int indexOfEntity = Entity.indexOf(searchEntity);
        List<String>EntityAtts = EntityAttributes.get(indexOfEntity);
        List<String>EntityTyps = EntityTypes.get(indexOfEntity);
        String Attributes = "{";
        for (int i = 1; i < EntityAtts.size(); i++) {
            Attributes = Attributes + "\"" + EntityAtts.get(i) + "\"" + ": " + Args.get(i);  
        }
        Attributes = Attributes + "}";
        PactAtom PI = new PactAtom(searchEntity + "_table" + " " + Args.get(0), Attributes);
        PI.setIndentation(3);
        PI.chooseCoreFunction(4);
        PactFunction PF = new PactFunction(Event, Args, String.join("\n", Lisp_Invariants) + "\n" + PI.Compile());
        
        return PF.Compile();
    }

    public String processInvokes() {
        String output = "";
        for (int i = 0; i < Invoked_Events.size(); i++) {
            List<String>Values = Events_Values.get(i);
            String currentCall = "(" + Invoked_Events.get(i) + " " + String.join(" ", Values) + ")";
            output += currentCall + "\n";
        }
        
        return output;
    }
    
    public String getProgram() {
        return Program;
    }
    
}

