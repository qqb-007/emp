import entity.Smuserword;
import service.SmuserwordImpl;
import service.SmuserwordService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SmuserwordService sws=new SmuserwordImpl();
        List<Smuserword> list=sws.queryAll();
        for (Smuserword smuserword : list) {
            System.out.println(smuserword);
        }
    }



}
