public class Main {
    private Table table = new Table();

    public static void main(String[] args) {
        Main main = new Main();
        main.table.setValue("A", 1, "10");
        main.table.setValue("A", 2, "2");
        int result = main.table.resultFunction("A",1,"+","A",2);
        System.out.println(result);
    }
}