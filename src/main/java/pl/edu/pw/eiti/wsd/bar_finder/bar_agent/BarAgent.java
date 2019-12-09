package pl.edu.pw.eiti.wsd.bar_finder.bar_agent;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import pl.edu.pw.eiti.wsd.bar_finder.BarFinderAgent;
import pl.edu.pw.eiti.wsd.bar_finder.bar_agent.behaviours.BarOfferManager;
import pl.edu.pw.eiti.wsd.bar_finder.commons.model_structures.Bar;
import pl.edu.pw.eiti.wsd.bar_finder.commons.model_structures.BarBeer;
import pl.edu.pw.eiti.wsd.bar_finder.commons.model_structures.ontology.PreferencesOntology;
import pl.edu.pw.eiti.wsd.bar_finder.utilities.BarFinderAgentNameUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static pl.edu.pw.eiti.wsd.bar_finder.utilities.BarFinderConstants.*;

public class BarAgent extends BarFinderAgent {

    private AID loudnessControllerAgentAID;
    private AID seatsControllerAgentAID;
    private AID resourcesControllerAgentAID;

    private Bar bar;
    private Codec codec = new SLCodec();
    private Ontology preferencesOntology = PreferencesOntology.getInstance();

    public AID getLoudnessControllerAgentAID() {
        return loudnessControllerAgentAID;
    }

    public void setLoudnessControllerAgentAID(AID loudnessControllerAgentAID) {
        this.loudnessControllerAgentAID = loudnessControllerAgentAID;
    }

    public AID getSeatsControllerAgentAID() {
        return seatsControllerAgentAID;
    }

    public void setSeatsControllerAgentAID(AID seatsControllerAgentAID) {
        this.seatsControllerAgentAID = seatsControllerAgentAID;
    }

    public AID getResourcesControllerAgentAID() {
        return resourcesControllerAgentAID;
    }

    public void setResourcesControllerAgentAID(AID resourcesControllerAgentAID) {
        this.resourcesControllerAgentAID = resourcesControllerAgentAID;
    }

    public List<BarBeer> getResourcesInfo() {
        return this.bar.getBeers();
    }

    public void setResourcesInfo(List<BarBeer> resourcesInfo) {
        this.bar.setBeers(resourcesInfo);
    }

    public Integer getFreeSeatsNumber() {
        return this.bar.getFreeSeats();
    }

    public void setFreeSeatsNumber(Integer seatsNumber) {
        this.bar.setFreeSeats(seatsNumber);
    }

    public Bar.LoudnessLevel getLoudnessLevel() {
        return this.bar.getLoudnessLevel();
    }

    public void setLoudnessLevel(Bar.LoudnessLevel loudnessLevel) {
        this.bar.setLoudnessLevel(loudnessLevel);
    }

    public Bar getBar() {
        return bar;
    }

    public Codec getCodec() {
        return codec;
    }

    public Ontology getPreferencesOntology() {
        return preferencesOntology;
    }

    protected void setup() {
        System.out.println("Hello World! My name is " + getLocalName());

        // Get agent parameters
        Object[] args = getArguments();
        if (args != null && args.length > 0)
            this.bar = (Bar) args[0];

        if (this.bar == null) {
            doDelete();
        } else {
            // Register agent
            ServiceDescription sd = new ServiceDescription();
            sd.setType(BAR_AGENT);
            sd.setName(getLocalName());
            register(sd);

            // Register language and ontology
            getContentManager().registerLanguage(codec);
            getContentManager().registerOntology(preferencesOntology);

            loudnessControllerAgentAID = new AID(
                    BarFinderAgentNameUtils.GetBarControllerName(bar.getName(), LOUDNESS_CONTROLLER_AGENT_NAME),
                    AID.ISLOCALNAME);
            seatsControllerAgentAID = new AID(
                    BarFinderAgentNameUtils.GetBarControllerName(bar.getName(), SEATS_CONTROLLER_AGENT_NAME),
                    AID.ISLOCALNAME);
            resourcesControllerAgentAID = new AID(
                    BarFinderAgentNameUtils.GetBarControllerName(bar.getName(), RESOURCES_CONTROLLER_AGENT_NAME),
                    AID.ISLOCALNAME);

            addBehaviour(new BarOfferManager());
        }
    }

    public List<AID> getNearbyBars() {
        //TODO: localization based
        //tmp
        List<AID> bars = new ArrayList<>(Arrays.asList(this.searchDF(BAR_AGENT)));
        bars.remove(this.getAID());
        Collections.shuffle(bars);
        int barsToReturn = bars.size() / 2 + 1;
        return bars.subList(0, barsToReturn);
    }
}
