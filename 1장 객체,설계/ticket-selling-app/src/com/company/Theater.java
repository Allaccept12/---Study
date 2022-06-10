package com.company;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    /***
     * 소극장은 먼저 관람객의 가방안에 초대장이 들어있는지 확인하고, 만약 초대장이 들어있다면 이벤트에 당첨된 관람객이므로 판매원에게서 받은 티켓을
     * 관람객의 가방안에 넣어준다. 가방안에 초대장이 없다면 티켓을 판매한다. 이격우 소극장은 관람개그이 가방에서 티켓금액만큼을 차감후에 매표소에 금액을
     * 증가시킨다. 마지막으로 소극장은 관람객의 가방안에 티켓을 넣어줌으로써 관람객의 입장절차가 끝이난다.
     *
     */

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
