package com.example.demo.Services;
import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Table.TableReponse;
import com.example.demo.DTO.Ticket.TicketReponse;
import com.example.demo.DTO.Ticket.TicketRequest;
import com.example.demo.Models.ClientEntity;
import com.example.demo.Models.Met.MetEntity;
import com.example.demo.Models.Met.PlatEntity;
import com.example.demo.Models.TableEntity;
import com.example.demo.Models.TicketEntity;
import com.example.demo.Reposetories.ClientRepository;
import com.example.demo.Reposetories.MetRepository;
import com.example.demo.Reposetories.TableRepository;
import com.example.demo.Reposetories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    ModelMapper mapper=new ModelMapper();
    private TicketRepository ticketRepository;
    private ClientRepository clietnRepository;
    private MetRepository metRepository;
    private TableRepository tableRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository,ClientRepository clietnRepository,MetRepository metRepository,TableRepository tableRepository) {
        super();
        this.ticketRepository = ticketRepository;
        this.clietnRepository= clietnRepository;
        this.metRepository= metRepository;
        this.tableRepository= tableRepository;
    }

    @Override
    public List<TicketReponse> getAllEntity() {

        List<TicketEntity> tickets = ticketRepository.findAll();
        List<TicketReponse> reponse = new ArrayList<>();
        for (TicketEntity ticket : tickets) {
            reponse.add(mapper.map(ticket, TicketReponse.class));
        }
        return reponse;
    }

    @Override
    public TicketReponse getEntityById(long id) {
        Optional<TicketEntity> opt = ticketRepository.findById(id);
        TicketEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Ticket with this Id is not found");
        return mapper.map(entity,TicketReponse.class);
    }

    @Override
    public TicketReponse addTicket(TicketRequest entityreq) {
        TicketEntity ticket=mapper.map(entityreq,TicketEntity.class);
        ticket.setDate(LocalDateTime.now());
        TicketEntity ticketinBase=ticketRepository.save(ticket);

        return mapper.map(ticketinBase,TicketReponse.class);
    }

    @Override
    public TicketReponse updateTicket(long id, TicketRequest newEntityreq) {

        TicketEntity newEntity =mapper.map(newEntityreq,TicketEntity.class );

        TicketReponse ticketrep =this.getEntityById(id);
        TicketEntity ticket =mapper.map(ticketrep,TicketEntity.class);

        if ( newEntity.getNumero() != 0)
            ticket.setNumero(newEntity.getNumero());

        if ( newEntity.getDate() != null)
            ticket.setDate(newEntity.getDate());

        if ( newEntity.getNbCouvert() != 0)
            ticket.setNbCouvert(newEntity.getNbCouvert());

        if ( newEntity.getAddition() != 0)
            ticket.setAddition(newEntity.getAddition());

        TicketEntity ticketsv=ticketRepository.save(ticket);
        return mapper.map(ticketsv,TicketReponse.class);
    }

    @Override
    public String deleteTicket(long id) {
        TicketReponse ticket = this.getEntityById(id);
        ticketRepository.deleteById(id);
        return "Ticket delted ! ";
    }

    // 1) Pour une période donnée quel est le plat le plus acheté :

    public MetReponse PlatPlusAchete(LocalDateTime begin, LocalDateTime end){
        List<TicketEntity> tickets=ticketRepository.findAll();
        List<Long> idPlatList=new ArrayList<>();
        for (TicketEntity ticket:tickets){
            if(ticket.getDate().isAfter(begin)&&ticket.getDate().isBefore(end)){

                for (MetEntity met:ticket.getMets()){
                    if(met instanceof PlatEntity){
                        idPlatList.add(met.getId());
                    }
                }
            }
        }
        Long metid= idPlatList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        MetEntity met=metRepository.findById(metid).get();
        return mapper.map(met,MetReponse.class);
    }

   // 2) Quel est le client le plus fidèle au restaurant :

    public ClientEntity ClientPlusFidel(){
        List<TicketEntity>tickets=ticketRepository.findAll();

        List<ClientEntity> client=  tickets.stream().map(tic->tic.getClient()).collect(Collectors.toList());

        ClientEntity clientfidel=client.stream().collect(Collectors.groupingBy(l->l, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        return clientfidel;
    }

    // 3) Quelle est la table la plus réservée :

    public TableReponse TablePlusReserve(){
        Map<Long,Integer> listTableWithkey=new HashMap<>();
        List<TableEntity> tables=tableRepository.findAll();
        for(TableEntity table:tables){
            listTableWithkey.put(table.getId(),table.getTickets().size());
        }
        Long toptable= listTableWithkey.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

        TableEntity table=tableRepository.findById(toptable).get();
        return mapper.map(table, TableReponse.class);
    }

    // 4) Quel est le jour de la semaine le plus réservé par un client donné :

    public LocalDateTime JourPlusResrve(long id) {
        Optional  <ClientEntity> client=clietnRepository.findById(id);
        LocalDateTime date=LocalDateTime.now();
        if(client.isPresent()){
            date= client.get().getTickets().stream().map(ticket->ticket.getDate())
                    .collect(Collectors.groupingBy(I->I, Collectors.counting()))
                    .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        }else throw new NoSuchElementException("Client with this Id is not found ");
        return date;
    }
    // 5) Retourner le revenu par jour, semaine et mois :
    //par jour

    public String RevenueDerniereDays(){
        List<TicketEntity> tickets=ticketRepository.findAll();
        double revenueJours=0;
        for (TicketEntity ticket:tickets){

            if (ticket.getDate().isAfter(LocalDateTime.now().minus(Period.ofDays(1)))){
                revenueJours=revenueJours+ticket.getAddition();
            }
        }
        return " Le Revenue jour derniere ="+revenueJours;
    }

    //pour semaine

    public String RevenueDerniereWeeks(){
        List<TicketEntity> tickets=ticketRepository.findAll();
        double revenueSemaine=0;
        for (TicketEntity ticket:tickets){
            if (ticket.getDate().isAfter(LocalDateTime.now().minus(Period.ofWeeks(1)))){
                revenueSemaine=revenueSemaine+ticket.getAddition();
            }
        }
        return "Le Revenue semaine derniere ="+revenueSemaine;
    }

    //pour mois
    public String RevenueDerniereMonths(){
        List<TicketEntity> tickets=ticketRepository.findAll();
        double revenuemois=0;
        for (TicketEntity ticket:tickets){
            if (ticket.getDate().isAfter(LocalDateTime.now().minus(Period.ofMonths(1)))){
                revenuemois=revenuemois+ticket.getAddition();
            }
        }
        return " Le Revenue moins derniere ="+revenuemois;
    }

    // 6) Retourner le revenu pour une période donnée.

    public double revenudansperiode(LocalDateTime debutperiode, LocalDateTime finperiode) {
        List<TicketEntity> tickets=ticketRepository.findAll();
        double revenu=0;
        for(TicketEntity ticket:tickets){
            if(ticket.getDate().isAfter(debutperiode)&&ticket.getDate().isBefore(finperiode)){
                revenu=ticket.getAddition()+revenu;
            }
        }
        return revenu;
    }



}
