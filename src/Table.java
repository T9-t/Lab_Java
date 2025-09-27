
public class Table {

    private int rows;
    private int cols;
    private int[][] table;

    public Table(int rows,int cols){

        this.rows = rows;
        this.cols = cols;
        table = new int[rows][cols];

        for (int i =0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                table[i][j] = 0;
            }
        }
    }
    public int getValue(int row,int col){
        return table[row][col];
    }
    public void setValue(int row,int col,int value){
        table[row][col] = value;
    }
    public void rows(){
        System.out.println("Rows: " + rows);
    }
    public void cols(){
        System.out.println("Rows: " + cols);
    }
    public String toString(){

        String tableLine = "";

        for (int i =0;i<rows;i++){
            for (int j = 0;j<cols;j++){

                tableLine += table[i][j] + " ";
            }
            if (i != (rows - 1)){
                tableLine += "\n";
            }
        }
        return tableLine;
    }
    public void average(){

        float sum = 0;

        for (int i =0;i<rows;i++){
            for (int j = 0;j<cols;j++){

                sum += table[i][j];
            }
        }
        sum = sum /(rows * cols);
        System.out.println("Average: " + sum);
    }
}
