import java.util.HashMap;

public class Table {
    private HashMap<HashMap<String, Integer>, String> table = new HashMap<>();

    public void setValue(String character, Integer number, String value) {
        HashMap<String, Integer> inputHashMap = new HashMap<>();
        inputHashMap.put(character, number);
        table.put(inputHashMap, value);
    }

    public String getValue(String character, Integer number) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put(character, number);
        return table.get(result);
    }

    public Integer resultFunction(String firstCharacter,
                                  Integer firstNumber,
                                  String operator,
                                  String secondCharacter,
                                  Integer secondNumber) {
        int firstValue;
        int secondValue;
        int result = 0;

        HashMap<String,Integer> tempHashMap = new HashMap<>();
        tempHashMap.put(firstCharacter,firstNumber);

        if (table.containsKey(tempHashMap)){
            firstValue = Integer.parseInt(table.get(tempHashMap));
            tempHashMap.clear();
        } else {
            firstValue = 0;
        }

        tempHashMap.put(secondCharacter,secondNumber);
        if (!table.containsKey(tempHashMap)){
            secondValue = 0;
        } else {
            secondValue = Integer.parseInt(table.get(tempHashMap));
            return switch (operator) {
                case "+" -> result = firstValue + secondValue;
                case "-" -> result = firstValue - secondValue;
                case "*" -> result = firstValue * secondValue;
                case "/" -> result = firstValue / secondValue;
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
        }
        System.out.println(result);
        return result;
    }

    public HashMap<HashMap<String, Integer>, String> getTable() {
        return table;
    }
}
