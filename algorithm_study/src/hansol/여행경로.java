package hansol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로 {
    private static class Ticket implements Comparable<Ticket> {
        String from;
        String to;
        boolean used = false;

        Ticket(String[] info) {
            this.from = info[0];
            this.to = info[1];
        }

        @Override
        public int compareTo(Ticket o) {
            if (from.equals(o.from)) {
                return to.compareTo(o.to);
            }
            return from.compareTo(o.from);
        }

    }

    Ticket[] tickets;
    List<String> answer;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        this.tickets = new Ticket[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            this.tickets[i] = new Ticket(tickets[i]);
        }
        Arrays.sort(this.tickets);

        dfs("ICN", "ICN", 0);

        return answer.get(0).split(" ");
    }

    private void dfs(String from, String route, int count) {
        if (!answer.isEmpty()) {
            return;
        }
        if (count == tickets.length) {
            answer.add(route);
            return;
        }

        for (Ticket ticket : tickets) {
            if (!ticket.used && ticket.from.equals(from)) {
                ticket.used = true;
                dfs(ticket.to, route + " " + ticket.to, count + 1);
                ticket.used = false;
            }
        }
    }
}
