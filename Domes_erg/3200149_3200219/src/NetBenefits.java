import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class NetBenefits {
    public static void main(String[] args) throws Exception{
        boolean b = false; // to programma perimenei na brei price otan einai true
        boolean FlagBuy; // brike string buy
        boolean FlagPrice; // brike string sell
        String str = null; // oi grammes toy arxeioy topothetountai prosorina edw
        BufferedReader reader = null;
        IntQueueImpl<Integer> QueueShares = new IntQueueImpl<>(); // oura gia posotita metoxwn
        IntQueueImpl<Integer> QueuePrice = new IntQueueImpl<>(); // oura gia aksia metoxwn
        try{
            reader = new BufferedReader(new FileReader(new File(args[0])));
            while((str =reader.readLine() )!= null){ // diabazei to arxeio txt mexri na brei keni grammi
                String[] line = str.split(" "); // xwrizei kathe xarakthira metaksi kenwn kai ta topotheti se pinaka
                int shares = 0;
                int result = 0; // teliko kerdos i zimia
                int diff = 0; // arxikopoiisi
                FlagBuy = false;
                FlagPrice = false;
                for(String word:line){ // iterating sto pinaka
                    if (FlagBuy == true){ // an brethike leksi buy
                        b = true;
                        QueueShares.put(Integer.valueOf(word)); // topotheteite akearaia morfi tou string tis posotitas tvn metwxwn
                        FlagBuy = false; // teleiwnei i agora
                    }
                    if(FlagPrice == true && b== true){ // brethike h leksi price
                        QueuePrice.put(Integer.valueOf(word)); //topotheteite akearaia morfi tou string tis aksias tvn metwxwn
                        FlagPrice = false;
                    }
                    else if(FlagPrice && !b){ // brethike sell
                        int SellPrice = Integer.parseInt(word); // twrini aksia
                        int buy = QueueShares.peek();
                        while (shares>0) { // oso mas menoun metoxes pou prepei na poylisoyme
                            if (shares>= buy) { // an oi metoxes pou prepei na poylithoun einai perissoteres apo to pio palio komvo tvn pio palivn pou agorasame
                                buy = QueueShares.get(); // afaireite o komvos (poulithikan)
                                result += buy * (SellPrice-QueuePrice.get()); // auksanetai to result
                                shares -= buy; // meiwnetai o arithmos twn metoxvn pou tha poylithoun
                            }
                            else{  // an oi metoxes pou prepei na poylithoun einai perissoteres apo to pio palio komvo tvn pio palivn pou agorasame
                                buy = QueueShares.get(); // afaireite o komvos (poulithikan)
                                diff = buy-shares; // diafora posotiton
                                buy = shares;
                                int price2 = QueuePrice.peek(); //kratame tin timi twn metoxwn toy teleutaioy komvoy
                                result += buy * (SellPrice-QueuePrice.get()); // auksanetai to result
                                shares -= buy; // meiwnetai o arithmos twn metoxvn pou tha poulithoun
                                QueueShares.put(diff); // aytes pou menoyn mpenoyn pali stin oura 
                                QueuePrice.put(price2); // stin idia timi me prin


                            }
                            buy = QueueShares.peek(); // oi epomenes metoxes pou tha poulithoyn
                        }
                        System.out.println("The result is");
                        System.out.println(result); // typownei to teliko apotelesma
                    }
                    if(word.equals("buy")){ // an i leksi einai buy
                        FlagBuy = true; // agorase
                    }
                    else if(word.equals("price")){ // an i leksi einai price
                        FlagPrice = true; // bale timi
                    }
                    else if(word.equals("sell")){ // an i leksi einai sell
                        b = false; // poylise

                    }
                    else if(!b){
                        shares = Integer.parseInt(word); // metoxes pou prepei na poulithoun
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
