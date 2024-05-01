package Github_200days.control_flow;

public class BlackJack {
    public static void main(String[] args) {
        String card = "jack";
        int currentTotalValue = 10;

        int currentValue = switch (card){
            case "king", "queen", "jack" -> 10;
            case "ace" -> {
                if(currentTotalValue<=10){
                    yield 11;
                }else{
                    yield 1;
                }
            }
            default -> Integer.parseInt(card);
        };
        System.out.printf("Current Card Value: %d%n", currentValue);
        System.out.printf("Total Value: %d%n", currentTotalValue+currentValue);

    }
}
