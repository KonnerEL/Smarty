
import Smarty.SmartyParser;
import Smarty.SmartyLexer;
import CodeBuilder.Transpiler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KonnerEL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        File f = new File(System.getProperty("user.dir") + "/examples/VotationSystem.sm");
        //File f = new File(args[0]);
        FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        SmartyLexer lexer = new SmartyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SmartyParser parser = new SmartyParser(tokens);
        Transpiler tr = new Transpiler();
        parser.addParseListener(tr);
        parser.contractDefinition();
        tr.buildPactSintax();
        String contract = tr.getProgram();
        System.out.println(contract);
        String fileName = f.getName().substring(0, f.getName().indexOf("."));
        File pactContract = new File(System.getProperty("user.dir") + "/examples/" + fileName + ".pact");
	FileWriter fileWriter = new FileWriter(pactContract);
	fileWriter.write(contract);
        fileWriter.flush();
	fileWriter.close();
    }
    
}
