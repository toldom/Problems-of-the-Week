//UWindsor POTW3 - UNKoolKatz
//Created by Marcus Toldo on Monday, November 19, 2017
//Last edited on Thursday, November 23, 2017

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfInputs = sc.nextInt();
        int first, second;
        ArrayList<KoolKat> KoolKatz = new ArrayList<>();

        /* Populates group members and adds
        each persons corresponding friendships*/
        for (int i = 0; i < numberOfInputs; i++) {

            first = sc.nextInt();
            second = sc.nextInt();

            //Do twice
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    CheckAdd(first, second, KoolKatz);
                } else {
                    CheckAdd(second, first, KoolKatz);
                }
            }
        }

        int usr;
        int postNum;
        int like;
        numberOfInputs = sc.nextInt();

        for (int i = 0; i < numberOfInputs; i++){
            usr = sc.nextInt();
            postNum = sc.nextInt();
            like = sc.nextInt();

            for (KoolKat temp : KoolKatz) {
                if (temp.ID == usr) {
                    temp.AddPost(postNum, like);
                }
            }
        }

        int keyUser = sc.nextInt();
        int threshold = sc.nextInt();

        for (KoolKat temp : KoolKatz) {

            if (temp.ID == keyUser) {
                temp.DetermineNotifications(threshold, KoolKatz);
            }
        }
    }

    /*
    Input: Recieves two ints (the person and their friend), as well as the AL of group members as input
    Output: void fn
    Purpose: Checks if the person is already a member of the group or not, if not will add them and set up
    friendships, if they are will just set up the friendship
     */
    private static void CheckAdd(int person, int friend, ArrayList<KoolKat> KoolKatz) {

        boolean isIn = false;

        for (KoolKat temp : KoolKatz) {
            if (temp.ID == person) {
                isIn = true;
            }
        }

        if (isIn) {
            for (KoolKat temp : KoolKatz) {
                if (temp.ID == person) {
                    temp.AddFriend(friend);
                    break;
                }
            }
        } else {
            KoolKat temp = new KoolKat(person);
            temp.AddFriend(friend);
            KoolKatz.add(temp);
        }

    }
}