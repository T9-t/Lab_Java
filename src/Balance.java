
public class Balance {

    private int scalesRight = 0;
    private int scalesLeft = 0;

    public void start(){

        result();
        addRight(5);
        result();
        addLeft(15);
        result();
    }
    private void addRight(int weight){
        scalesRight += weight;
    }
    private void addLeft(int weight){
        scalesLeft += weight;
    }
    private void result(){

        String res = "";
        if (scalesRight == scalesLeft){
            res = "=";
        }
        else if (scalesRight > scalesLeft){
            res = "R";
        }
        else {
            res = "L";
        }
        System.out.println(res);
    }
}
