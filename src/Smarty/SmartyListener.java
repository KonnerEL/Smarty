package Smarty;

// Generated from Smarty.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmartyParser}.
 */
public interface SmartyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmartyParser#contractDefinition}.
	 * @param ctx the parse tree
	 */
	void enterContractDefinition(SmartyParser.ContractDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#contractDefinition}.
	 * @param ctx the parse tree
	 */
	void exitContractDefinition(SmartyParser.ContractDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(SmartyParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(SmartyParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(SmartyParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(SmartyParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(SmartyParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(SmartyParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#custom_event}.
	 * @param ctx the parse tree
	 */
	void enterCustom_event(SmartyParser.Custom_eventContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#custom_event}.
	 * @param ctx the parse tree
	 */
	void exitCustom_event(SmartyParser.Custom_eventContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SmartyParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SmartyParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#entities}.
	 * @param ctx the parse tree
	 */
	void enterEntities(SmartyParser.EntitiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#entities}.
	 * @param ctx the parse tree
	 */
	void exitEntities(SmartyParser.EntitiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#subjects}.
	 * @param ctx the parse tree
	 */
	void enterSubjects(SmartyParser.SubjectsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#subjects}.
	 * @param ctx the parse tree
	 */
	void exitSubjects(SmartyParser.SubjectsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#insert_object}.
	 * @param ctx the parse tree
	 */
	void enterInsert_object(SmartyParser.Insert_objectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#insert_object}.
	 * @param ctx the parse tree
	 */
	void exitInsert_object(SmartyParser.Insert_objectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#get_info}.
	 * @param ctx the parse tree
	 */
	void enterGet_info(SmartyParser.Get_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#get_info}.
	 * @param ctx the parse tree
	 */
	void exitGet_info(SmartyParser.Get_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#invariant}.
	 * @param ctx the parse tree
	 */
	void enterInvariant(SmartyParser.InvariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#invariant}.
	 * @param ctx the parse tree
	 */
	void exitInvariant(SmartyParser.InvariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(SmartyParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(SmartyParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(SmartyParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(SmartyParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void enterPostcondition(SmartyParser.PostconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void exitPostcondition(SmartyParser.PostconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#exceptionHandler}.
	 * @param ctx the parse tree
	 */
	void enterExceptionHandler(SmartyParser.ExceptionHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#exceptionHandler}.
	 * @param ctx the parse tree
	 */
	void exitExceptionHandler(SmartyParser.ExceptionHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(SmartyParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(SmartyParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SmartyParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SmartyParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#left_Side}.
	 * @param ctx the parse tree
	 */
	void enterLeft_Side(SmartyParser.Left_SideContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#left_Side}.
	 * @param ctx the parse tree
	 */
	void exitLeft_Side(SmartyParser.Left_SideContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#right_Side}.
	 * @param ctx the parse tree
	 */
	void enterRight_Side(SmartyParser.Right_SideContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#right_Side}.
	 * @param ctx the parse tree
	 */
	void exitRight_Side(SmartyParser.Right_SideContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SmartyParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SmartyParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#invoke}.
	 * @param ctx the parse tree
	 */
	void enterInvoke(SmartyParser.InvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#invoke}.
	 * @param ctx the parse tree
	 */
	void exitInvoke(SmartyParser.InvokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmartyParser#invocation_argument}.
	 * @param ctx the parse tree
	 */
	void enterInvocation_argument(SmartyParser.Invocation_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmartyParser#invocation_argument}.
	 * @param ctx the parse tree
	 */
	void exitInvocation_argument(SmartyParser.Invocation_argumentContext ctx);
}