package resources_chief;

import java.util.List;

public class ChefDeChantier
{
    private String fullName;
    private List<Responsable> responsables;
    private List<Projet> projets;
    private List<LesMateriaux> materiaux;
    private List<Rapport> rapports;
    private List<ClientRequest> clientRequests;

    public ChefDeChantier(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public List<Responsable> getResponsables()
    {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables)
    {
        this.responsables = responsables;
    }

    public List<Projet> getProjets()
    {
        return projets;
    }

    public void setProjets(List<Projet> projets)
    {
        this.projets = projets;
    }

    public List<LesMateriaux> getMateriaux()
    {
        return materiaux;
    }

    public void setMateriaux(List<LesMateriaux> materiaux)
    {
        this.materiaux = materiaux;
    }

    public List<Rapport> getRapports()
    {
        return rapports;
    }

    public void setRapports(List<Rapport> rapports)
    {
        this.rapports = rapports;
    }

    public List<ClientRequest> getClientRequests()
    {
        return clientRequests;
    }

    public void setClientRequests(List<ClientRequest> clientRequests)
    {
        this.clientRequests = clientRequests;
    }

    public void surveiller()
    {
        System.out.println("Surveillance du chantier par " + fullName);
    }
}
