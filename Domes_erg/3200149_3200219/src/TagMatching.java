import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class TagMatching {
    public static void main(String[] args) throws Exception{
        StringStackImpl<String> StackHtml  = new StringStackImpl<>();
        String topStr = null;
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString(); // dhmiourgw ena string me ta dedomena tou html file

        int l = content.length();
        int count = 0;
        boolean flag1 = false;         //elegxei an einai tag anoigmatos
        boolean flag2 = false;         //elegxei an einai tag kleisimatos
        boolean flag = true;           //elegxei an einai ta tags zeugaronoun swsta h oxi
        String s ="";
        String s2 ="";
        for(int i =0; i<l-1; i++){
            char ch = content.charAt(i);
            if (flag1){
                s+=ch;                 //prosthetw ena ena ta grammata ths lejis(tag anoigmatos) sto string
            }
            if(flag2){
                count+=1;
                if(count>2){           //an count>2 shmainei oti exoume to prwto gramma apo ta chars giati 1o <  kai 2o /
                    s2 += ch;          //prosthetw ena ena ta grammata ths lejis(tag kleisimatos) sto string
                }
            }
            if (ch =='<'&& content.charAt(i+1)!='/'){
                flag1 = true;
            }
            else if(ch =='<'&& content.charAt(i+1)=='/'){
                flag2 = true;
                count+=1;
            }
            if(flag1 && content.charAt(i+1) == '>'){
                StackHtml.push(s);
                s = "";
                flag1 = false;
            }
            if(flag2 && content.charAt(i+1) == '>'){
                flag2 = false;
                count = 0;
                if(StackHtml.isEmpty()){ // an h stack einai adeia kai pame na kanoume peek ena stoixeio tha bgalei exception error opote ta tags einai lathos giati perisseuei ena
                    flag = false;
                }
                else{
                    topStr = StackHtml.peek();
                    if(topStr.equals(s2)){ // an ta strings einai isa tote ta tags einai swsta
                        s2 = "";
                        StackHtml.pop();
                    }
                    else{
                        flag = false;
                    }
                }

            }

            //System.out.println(ch);
        }
        StackHtml.printStack(System.out);
        if(flag && StackHtml.isEmpty()){ // an h flag einai alithis kai h stoiba adeia tote swsta tags
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

    }
}