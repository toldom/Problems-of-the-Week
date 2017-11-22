import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfInputs = sc.nextInt();

        int[][] friendRelations = new int[numberOfInputs][2];


        for (int i = 0; i < numberOfInputs; i++) {

            int person = sc.nextInt();
            int friend = sc.nextInt();

            friendRelations[i][0] = person;
            friendRelations[i][1] = friend;
        }

        //Creating out ArrayList of people specified in the input
        ArrayList<KoolKat> KoolKatz = new ArrayList<>();
        ArrayList<Integer> uniquePeople = new ArrayList<>();
        for (int i = 0; i < numberOfInputs; i++) {
            if (!uniquePeople.contains(friendRelations[i][0])) {
                KoolKatz.add(new KoolKat(friendRelations[i][0]));
                uniquePeople.add(friendRelations[i][0]);
            }
            if (!uniquePeople.contains(friendRelations[i][1])) {
                KoolKatz.add(new KoolKat(friendRelations[i][1]));
                uniquePeople.add(friendRelations[i][1]);
            }

        }

        //Adding all these peoples friend relations
        for (int i = 0; i < numberOfInputs; i++) {
            for (KoolKat temp : KoolKatz) {
                if (temp.ID == friendRelations[i][0]) {
                    temp.AddFriend(friendRelations[i][1]);
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
}
