package com.stat.app.EventModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String eventUri;
    
    @Column(nullable=false)
    private String eventPrincipal;

    @Column(nullable=false)
    private String eventMethod;

    @Column(nullable=false)
    private Integer eventStatus;

    Event() {}

    public Event(Long id, String eventUri, String eventPrincipal, String eventMethod, Integer eventStatus) {
        this.id = id;
        this.eventUri = eventUri;
        this.eventPrincipal = eventPrincipal;
        this.eventMethod = eventMethod;
        this.eventStatus = eventStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventUri() {
        return eventUri;
    }

    public void setEventUri(String eventUri) {
        this.eventUri = eventUri;
    }

    public String getEventPrincipal() {
        return eventPrincipal;
    }

    public void setEventPrincipal(String eventPrincipal) {
        this.eventPrincipal = eventPrincipal;
    }

    public String getEventMethod() {
        return eventMethod;
    }

    public void setEventMethod(String eventMethod) {
        this.eventMethod = eventMethod;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eventMethod == null) ? 0 : eventMethod.hashCode());
        result = prime * result + ((eventPrincipal == null) ? 0 : eventPrincipal.hashCode());
        result = prime * result + ((eventStatus == null) ? 0 : eventStatus.hashCode());
        result = prime * result + ((eventUri == null) ? 0 : eventUri.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (eventMethod == null) {
            if (other.eventMethod != null)
                return false;
        } else if (!eventMethod.equals(other.eventMethod))
            return false;
        if (eventPrincipal == null) {
            if (other.eventPrincipal != null)
                return false;
        } else if (!eventPrincipal.equals(other.eventPrincipal))
            return false;
        if (eventStatus == null) {
            if (other.eventStatus != null)
                return false;
        } else if (!eventStatus.equals(other.eventStatus))
            return false;
        if (eventUri == null) {
            if (other.eventUri != null)
                return false;
        } else if (!eventUri.equals(other.eventUri))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Event [eventMethod=" + eventMethod + ", eventPrincipal=" + eventPrincipal + ", eventStatus="
                + eventStatus + ", eventUri=" + eventUri + ", id=" + id + "]";
    }

    


}
