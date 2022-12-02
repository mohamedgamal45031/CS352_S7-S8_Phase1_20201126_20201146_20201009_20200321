package FawrySystem;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Search search=Search.getInstance();

          search.putService("WERechrage" , new  Discount(.05,search.getService("WERechrage")));

          search.getService("WERechrage").ExecuteService();

          Search search2 =Search.getInstance();

        search.getService("WERechrage").ExecuteService();

    }
}
