import Expense from '../lib/models/Expense.js'
import SimpleRuleEngine from '../lib/services/impl/SimpleRuleEngine.js'
import RuleManagerRunner from '../lib/utils/RuleManagerRunner.js'
import ExpenseType from '../lib/models/ExpenseType.js'

(() => {
    const ExpenseTypeRESTAURANT = ExpenseType.RESTAURANT;

    let expenses = [
        new Expense("1", "1", 10.0, ExpenseTypeRESTAURANT),
        new Expense("2", "1", 20.0, ExpenseTypeRESTAURANT),
        new Expense("3", "1", 300.0, ExpenseTypeRESTAURANT)
    ];

    const ruleManagerRunner = new RuleManagerRunner(new SimpleRuleEngine());
    ruleManagerRunner.run(expenses);
})();

(()=> {
    const ExpenseTypeRESTAURANT = ExpenseType["RESTAURANT"];
    let expenses = [
        new Expense("1","1",10.0,ExpenseTypeRESTAURANT),
        new Expense("2","1",20.0,ExpenseTypeRESTAURANT),
        new Expense("3","1",300.0,ExpenseTypeRESTAURANT)

    ]

    let ruleManagerRunner = new RuleManagerRunner(new SimpleRuleEngine())
    ruleManagerRunner.run(expenses)
})()