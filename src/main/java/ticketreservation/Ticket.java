package ticketreservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Ticket_table")
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String ticketid;
    private String status;

    @PostPersist
    public void onPostPersist(){
        Ticketregistered ticketregistered = new Ticketregistered();
        BeanUtils.copyProperties(this, ticketregistered);
        ticketregistered.publishAfterCommit();


        Able able = new Able();
        BeanUtils.copyProperties(this, able);
        able.publishAfterCommit();


        Disable disable = new Disable();
        BeanUtils.copyProperties(this, disable);
        disable.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
