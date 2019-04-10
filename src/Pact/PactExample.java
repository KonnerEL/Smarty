/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pact;

/**
 *
 * @author KonnerEL
 */
public class PactExample {
    public static String getContract() {
        String output = "(define-keyset 'admin-keyset (read-keyset \"admin-keyset\"))\n" +
            "\n" +
            "(module contract 'admin-keyset\n" +
            "  (defschema Account\n" +
            "    Balance:decimal\n" +
            "  )\n" +
            "\n" +
            "  (deftable Account_table:{Account})\n" +
            "\n" +
            "  (defun create-account (name initial-balance)\n" +
            "    (enforce (>= initial-balance 0.0) \"Initial balances must be >= 0.\")\n" +
            "    (insert Account_table name\n" +
            "            { \n" +
            "                \"Balance\": initial-balance\n" +
            "            }))\n" +
            "\n" +
            "  (defun get_info (name)\n" +
            "    (with-read Account_table name\n" +
            "      { \"Balance\":= balance }\n" +
            "\n" +
            "      (format \"{} has {}\" [name balance]) ))\n" +
            "\n" +
            "  (defun transfer_to (from to amount)\n" +
            "    (with-read Account_table from {\"Balance\" := from_Balance } \n" +
            "     (with-read Account_table to {\"Balance\" := to_Balance } \n" +
            "      (enforce (> amount 0.0) \"Negative Transaction Amount\")\n" +
            "      (enforce (>= from_Balance amount) \"Insufficient Funds\")\n" +
            "      (update Account_table from {\"Balance\": (- from_Balance amount) })\n" +
            "      (update Account_table to {\"Balance\": (+ to_Balance amount) })))\n" +
            "  )\n" +
            "\n" +
            ")\n" +
            "\n" +
            "(create-table Account_table)\n" +
            "(create-account \"Jose\" 100.25 )\n" +
            "(create-account \"Nestor\" 250.0 )\n" +
            "(transfer_to \"Jose\" \"Nestor\" 25.0)\n" +
            "(+ (+ (get_info \"Jose\") \"\\n\") (get_info \"Nestor\"))";
//        String output = "(define-keyset 'admin-keyset (read-keyset \"admin-keyset\"))\n";
//        output = output + "(module contract 'admin-keyset\n";
//        output = output + " (defschema Account\n";
//        output = output + "   Balance:decimal\n";
//        output = output + " )";
//        output = output + " (deftable Account_table:{Account})\n";
//        output = output + " (defun create-account (name initial-balance)\n";
//        output = output + "   (enforce (>= initial-balance 0.0) \"Initial balances must be >= 0.\")\n";
//        output = output + "    (insert Account_table name { \"Balance\": initial-balance\n";
//        output = output + " (defun get_info (name)\n";
//        output = output + "   (with-read Account_table name { \"Balance\": initial-balance\n";
//        output = output +    
          return output;
    }
    

}



