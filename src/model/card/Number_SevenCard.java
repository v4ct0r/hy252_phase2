package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Number_SevenCard extends Number_Card {

    public Number_SevenCard() {
        super(7, "seven");
    }

    /**
     * Move the pawn forward 7 spaces
     * @param pawn
     * @param player1
     * @param player2
     * pre-condition: the other same team pawn can not move (ether in home or start square)
     * post-condition: pawn move forward 7 space
     */
    public int seven(Pawn pawn, Player player1, Player player2) {
        if (pawn.isStart() || pawn.getHome()) {
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + getValue()) || teammate_is_home(pawn, player1, player2)) {
            pawn.setMoveable(true);
            if (pawn.getPosition() + getValue() > 71) {
                if (Objects.equals(pawn.getColor(), "yellow")) {
                    if (pawn.getPosition() + getValue() - 72 < 3)
                        return pawn.getPosition() + getValue() - 72;
                    else
                        return pawn.getPosition() + getValue() - 72 + 6;
                } else {
                    if (pawnSkipsHome(pawn, player1, player2)) {
                        pawn.setMoveable(false);
                        return pawn.getPosition();
                    }
                    return pawn.getPosition() + getValue() - 72;
                }
            }
            if (Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() + getValue() > 2 && pawn.getPosition() + getValue() <= 8)
                return pawn.getPosition() + getValue() + 6;
            if (Objects.equals(pawn.getColor(), "red") && pawn.getPosition() + getValue() > 38 && pawn.getPosition() + getValue() <= 44)
                return pawn.getPosition() + getValue() + 6;
            if (Objects.equals(pawn.getColor(), "red") && pawn.getPosition() < 39 && pawn.getPosition() + getValue() > 44)
                return pawn.getPosition() + getValue() + 6;
            if (Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() < 3 && pawn.getPosition() + getValue() > 8)
                return pawn.getPosition() + getValue() + 6;
            if (pawnSkipsHome(pawn, player1, player2)) {
                pawn.setMoveable(false);
                return pawn.getPosition();
            }
            //return 13;
            return pawn.getPosition() + getValue();
        }
        pawn.setMoveable(false);
        return pawn.getPosition();

    }
    /**
     * Split 7 moves forward to both pawns
     * @param pawn
     * @param player1
     * @param player2
     * pre-condition: both pawns are moveable (not in home or start square)
     * post-condition: pawn move forward 7-i spaces , i{1,2,3,4,5,6,7}
     */
    public int[] seven_7(Pawn pawn, Player player1, Player player2) {

        if (pawn.isStart() || pawn.getHome()) {
            pawn.setMoveable(false);
            return new int[]{pawn.getPosition(), pawn.getPosition(), pawn.getPosition(), pawn.getPosition(), pawn.getPosition(), pawn.getPosition(), pawn.getPosition()};
        }
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            pawn.setMoveable(true);
            if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + i + 1) || teammate_is_home(pawn, player1, player2)) {


                if (pawn.getPosition() + i + 1 > 71) {
                    if (Objects.equals(pawn.getColor(), "yellow")) {
                        if (pawn.getPosition() + i + 1 - 72 < 3) {
                            arr[i] = pawn.getPosition() + i + 1 - 72;
                            continue;
                        } else {
                            arr[i] = pawn.getPosition() + i + 1 - 72 + 6;
                            continue;
                        }
                    } else {
                        if (pawnSkipsHome(pawn, player1, player2)) {
                            arr[i] = pawn.getPosition();
                            continue;
                        }
                        arr[i] = pawn.getPosition() + i + 1 - 72;
                        continue;
                    }
                }
                if (Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() + i + 1 > 2 && pawn.getPosition() + i + 1 <= 8) {
                    arr[i] = pawn.getPosition() + i + 1 + 6;
                    continue;
                }
                if (Objects.equals(pawn.getColor(), "red") && pawn.getPosition() + i + 1 > 38 && pawn.getPosition() + i + 1 <= 44) {
                    arr[i] = pawn.getPosition() + i + 1 + 6;
                    continue;
                }
                if (Objects.equals(pawn.getColor(), "red") && pawn.getPosition() < 39 && pawn.getPosition() + i + 1 > 44) {
                    arr[i] = pawn.getPosition() + i + 1 + 6;
                    continue;
                }
                if (Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() < 3 && pawn.getPosition() + i + 1 > 8) {
                    arr[i] = pawn.getPosition() + i + 1 + 6;
                    continue;
                }
                if (pawnSkipsHome_Custom(pawn, player1, player2, i + 1)) {
                    arr[i] = pawn.getPosition();
                    continue;
                }
                arr[i] = pawn.getPosition() + i + 1;

            } else {
                arr[i] = pawn.getPosition();
            }

        }
        check_if_teammate_is_able_to_move(pawn, player1, player2, arr);
        return arr;
    }
    /**
     * check the validity of the move that are in the array
     * @param p
     * @param player1
     * @param player2
     * @param arr
     */
    private void check_if_teammate_is_able_to_move(Pawn p, Player player1, Player player2, int[] arr) {
        int count = 0;

        if (p.getColor().equals("red")) {
            if (p.getId() == 1) {
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]==p.getPosition()) {
                        count++;
                        continue;
                    }
                    if (!able_to_move(player1.getPawn2(), player1, player2, 7 - i - 1 ,arr,i)) {
                        arr[i] = p.getPosition();
                        count++;
                    }
                }
            } else if (p.getId() == 2) {
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]==p.getPosition()) {
                        count++;
                        continue;
                    }
                    if (!able_to_move(player1.getPawn1(), player1, player2, 7 - i - 1,arr,i)) {
                        arr[i] = p.getPosition();
                        count++;
                    }
                }

            }
        } else if (p.getColor().equals("yellow")) {
            if (p.getId() == 1) {
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]==p.getPosition()) {
                        count++;
                        continue;
                    }
                    if (!able_to_move(player2.getPawn2(), player1, player2, 7 - i - 1,arr,i)) {
                        arr[i] = p.getPosition();
                        count++;
                    }
                }
            } else if (p.getId() == 2) {
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]==p.getPosition()) {
                        count++;
                        continue;
                    }
                    if (!able_to_move(player2.getPawn1(), player1, player2, 7 - i - 1,arr,i)) {
                        arr[i] = p.getPosition();
                        count++;
                    }
                }
            }
        }
        if(count==7)
            p.setMoveable(false);
        else
            p.setMoveable(true);

    }
    /**
     * check if the other pawn of the same team is in home
     * check if the prices of the array are able to skip home and disqualify those
     * check if the other pawn of the same team able to move considering the move that the first pawn could make
     * @param pawn2
     * @param player1
     * @param player2
     * @param k
     * @param arr
     * @param i
     * @return
     */
    private boolean able_to_move(Pawn pawn2, Player player1, Player player2, int k, int[] arr, int i) {
        if (pawn2.isStart() || pawn2.getHome())
            return false;

        if (pawnSkipsHome_Custom(pawn2, player1, player2, k)){
            return false;
        }

        if (arr[i]==seven_7diff(pawn2, player1, player2, k)) {
            if(Objects.equals(pawn2.getColor(), "red") && arr[i]==player1.getHomePosition()) //if(arr[i]==player1.getHomePosition() allow this arr[i]==seven_7diff(pawn2, player1, player2, k) to happen
                return true;
            if(Objects.equals(pawn2.getColor(), "yellow") && arr[i]==player2.getHomePosition())
                return true;
            return false;
        }
        return true;
    }

    private boolean pawnSkipsHome_Custom(Pawn pawn, Player player1, Player player2, int value) {
        if (Objects.equals(pawn.getColor(), "red")) {
            if (pawn.getPosition() < player1.getHomePosition()) {
                if (pawn.getPosition() + value > player1.getHomePosition())
                    return true;
            }else if (pawn.getPosition() - 72 + value > player1.getHomePosition())
                return true;
        } else if (Objects.equals(pawn.getColor(), "yellow")) {
            if (pawn.getPosition() < player2.getHomePosition())
                if (pawn.getPosition() + value > player2.getHomePosition())
                    return true;
        }
        return false;
    }
    /**
     * Move the pawn forward 7-i spaces , i{1,2,3,4,5,6,7}
     * @param pawn
     * @param player1
     * @param player2
     * @param value
     * pre-condition: the other same team pawn moved less than 7 spaces
     * post-condition: pawn move forward 7-i spaces
     */
    public int seven_7diff(Pawn pawn, Player player1, Player player2, int value) {

        if(pawn.isStart() || pawn.getHome()){
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + value) || teammate_is_home(pawn,player1,player2)){
            pawn.setMoveable(true);
            if(pawn.getPosition() + value > 71){
                if(Objects.equals(pawn.getColor(), "yellow")) {
                    if (pawn.getPosition() + value - 72 < 3)
                        return pawn.getPosition() + value - 72;
                    else
                        return pawn.getPosition() + value - 72 + 6;
                }else {
                    if(pawnSkipsHome(pawn, player1, player2)) {
                        pawn.setMoveable(false);
                        return pawn.getPosition();
                    }
                    return pawn.getPosition() + value - 72;
                }
            }
            if(Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() + value > 2 && pawn.getPosition() + value <= 8)
                return pawn.getPosition() + value + 6;
            if(Objects.equals(pawn.getColor(), "red") && pawn.getPosition() + value > 38 && pawn.getPosition() + value <= 44)
                return pawn.getPosition() + value + 6;
            if(Objects.equals(pawn.getColor(), "red") && pawn.getPosition() <39 && pawn.getPosition() + value > 44)
                return pawn.getPosition() + value + 6;
            if(Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() <3 && pawn.getPosition() + value > 8)
                return pawn.getPosition() + value + 6;
            if(pawnSkipsHome_Custom(pawn, player1, player2, value)) {
                pawn.setMoveable(false);
                return pawn.getPosition();
            }

            return pawn.getPosition() + value;
        }
        pawn.setMoveable(false);
        return pawn.getPosition();

    }
}
