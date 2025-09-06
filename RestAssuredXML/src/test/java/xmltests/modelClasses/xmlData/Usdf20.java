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

    @XmlElement(name = "PoolStandings")  // Each individual unit standing
    private List<PoolStanding> poolStandings;

    @XmlElement(name = "EventBreakdown")  // Each individual participant
    private EventBreakdown eventBreakdown;

    @XmlElement(name = "Participants")  // Each individual participant
    private Participant participant;

    @XmlElement(name = "PersonProfile")  // Each individual person profile
    private PersonProfile personProfile;

    @XmlElement(name = "CompetitionProfile")  // Each individual person profile
    private CompetitionProfile competitionProfile;

    public List<EventStanding> getEventStandings() {return eventStandings;}

    public void setEventStandings(List<EventStanding> eventStandings) {
        this.eventStandings = eventStandings;
    }

    public List<UnitStanding> getUnitStandings() {return unitStandings;}

    public void setUnitStandings(List<UnitStanding> unitStandings) {
        this.unitStandings = unitStandings;
    }

    public List<PoolStanding> getPoolStandings() {return poolStandings;}

    public void setPoolStandings(List<PoolStanding> poolStandings) {
        this.poolStandings = poolStandings;
    }

    public EventBreakdown getEventBreakdown() {
        return eventBreakdown;
    }

    public void setEventBreakdown(EventBreakdown eventBreakdown) {
        this.eventBreakdown = eventBreakdown;
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

    public CompetitionProfile getCompetitionProfile() {
        return competitionProfile;
    }

    public void setCompetitionProfile(CompetitionProfile competitionProfile) {this.competitionProfile = competitionProfile;}

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


