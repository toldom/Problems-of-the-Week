//UWindsor POTW3 - UNKoolKatz
//Created my Marcus Toldo on Monday, November 19, 2017
//Last edited on Friday, November 24, 2017

import java.util.ArrayList;

class KoolKat {

    private ArrayList<Integer> friends = new ArrayList<>();
    private ArrayList<Integer> likedPosts = new ArrayList<>();
    private ArrayList<Integer> dislikedPosts = new ArrayList<>();
    int ID;

    KoolKat(int ID) {
        this.ID = ID;
    }

    void AddFriend(int f) {
        friends.add(f);
    }

    void AddPost(int p, int l) {

        if (l == 1) {
            likedPosts.add(p);
        } else {
            dislikedPosts.add(p);
        }
    }

    void DetermineNotifications(int t, ArrayList<KoolKat> KoolKatz) {

        ArrayList<Integer> friendsLikedPosts = new ArrayList<>();
        ArrayList<Integer> friendsDislikedPosts = new ArrayList<>();
        ArrayList<Integer> worthyPosts = new ArrayList<>();
        ArrayList<Integer> unworthyPosts = new ArrayList<>();

        for (int i : friends) {
            for (KoolKat temp : KoolKatz) {
                if (temp.ID == i) {
                    friendsLikedPosts.addAll(temp.likedPosts);
                    friendsDislikedPosts.addAll(temp.dislikedPosts);
                }
            }
        }

        int count = 0;

        for (int i : friendsLikedPosts) {

            if (!worthyPosts.contains(i) && !unworthyPosts.contains(i)) {
                for (int j : friendsLikedPosts) {
                    if (i == j) {
                        count++;
                    }
                }

                for (int j : friendsDislikedPosts) {
                    if (i == j) {
                        count--;
                    }
                }

                if (count >= t) {
                    worthyPosts.add(i);
                } else {
                    unworthyPosts.add(i);
                }

                count = 0;
            }
        }

        for (int i : worthyPosts) {
            System.out.print(i + "\n");
        }
    }
}

