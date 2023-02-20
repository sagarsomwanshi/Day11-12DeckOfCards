public class DeckOfCards { int randomSuitIndex;
    int randomRankIndex;
    Cards[][] distributedCards = new Cards[4][9];
    boolean[][] previouslyDistributedCard = new boolean[4][13];
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    void print() {
        int playerRank;
        for (int i = 0; i < distributedCards.length; i++) {
            playerRank = i + 1;
            System.out.println("Player " + playerRank);
            for (int j = 0; j < distributedCards[i].length; j++) {
                Cards card = distributedCards[i][j];
                System.out.print(card + "\t");
            }
            System.out.println();
        }
    }

    int[] lastPlayerToCardIndex = new int[]{0, 0};

    void cardSelection() {
        int playerIndex = lastPlayerToCardIndex[0];
        int cardIndex = lastPlayerToCardIndex[1];


        if (playerIndex == 3 && cardIndex == 9) {
            return;
        }
        randomSuitIndex = (int) (Math.random() * 4);
        randomRankIndex = (int) (Math.random() * 13);

        while (previouslyDistributedCard[randomSuitIndex][randomRankIndex]) {
            randomSuitIndex = (int) (Math.random() * 4);
            randomRankIndex = (int) (Math.random() * 13);
        }

        distributedCards[playerIndex][cardIndex] = new Cards(suits[randomSuitIndex], ranks[randomRankIndex]);

        previouslyDistributedCard[randomSuitIndex][randomRankIndex] = true;
        if (cardIndex == 8) {

            lastPlayerToCardIndex[0] = playerIndex + 1;
            lastPlayerToCardIndex[1] = 0;
        } else {

            lastPlayerToCardIndex[0] = playerIndex;
            lastPlayerToCardIndex[1] = cardIndex + 1;
        }
    }
}
