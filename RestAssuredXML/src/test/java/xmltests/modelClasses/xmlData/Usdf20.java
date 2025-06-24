package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Usdf20")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usdf20 {

    @XmlElement(name = "EventStandings")  // Each individual event standing
    private List<EventStanding> eventStandings;

    @XmlElement(name = "UnitStandings")  // Each individual unit standing
    private List<UnitStanding> unitStandings;

    @XmlElement(name = "Participants")  // Each individual participant
    private Participant participant;

    @XmlElement(name = "PersonProfile")  // Each individual person profile
    private PersonProfile personProfile;

    public List<EventStanding> getEventStandings() {return eventStandings;}

    public void setEventStandings(List<EventStanding> eventStandings) {
        this.eventStandings = eventStandings;
    }

    public List<UnitStanding> getUnitStandings() {return unitStandings;}

    public void setUnitStandings(List<UnitStanding> unitStandings) {
        this.unitStandings = unitStandings;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public PersonProfile getPersonProfile() {
        return personProfile;
    }

    public void setPersonProfile(PersonProfile personProfile) {this.personProfile = personProfile;}

    @Override
    public String toString() {
        return "Usdf20{\n" +
                "    eventStandings=" + eventStandings + ",\n" +
                "    participant=" + participant + "\n" +
                "    personProfile=" + personProfile + "\n" +
                "    unitStandings=" + unitStandings + ",\n" +
                "}";
    }

}


