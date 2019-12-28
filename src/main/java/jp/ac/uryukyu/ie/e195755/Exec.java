package jp.ac.uryukyu.ie.e195755;

public class Exec {
    public static void main(String[] args){
        Client client = new Client(8080);
        String str = "puyopuyo";
        boolean e = client.sendMessage(str);
        if (e){
            System.out.println("You Send Massage");
        }else{
            System.out.println("You can't Send Massage");
        }
    }
}
