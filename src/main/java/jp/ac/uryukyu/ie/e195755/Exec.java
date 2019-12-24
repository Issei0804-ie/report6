package jp.ac.uryukyu.ie.e195755;

public class Exec {
    public static void main(String[] args){
        Client client = new Client(8080);
        byte[]  a = {5,2,3};
        int e = client.sendMessage(a);
        if (e==1){
            System.out.println("You Send Massage");
        }else{
            System.out.println("You can't Send Massage");
        }
    }
}
