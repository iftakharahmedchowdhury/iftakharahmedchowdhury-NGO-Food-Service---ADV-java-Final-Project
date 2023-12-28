package dev.restController.Restaurant;

import dev.domain.Admin.CollectRequestWithItems;
import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;
import dev.domain.User.User;
import dev.service.Restaurant.CollectRequestItemService;
import dev.service.Restaurant.CollectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CollectRequestController {

    private CollectRequestService collectRequestService;
    private CollectRequestItemService collectRequestItemService;

    /*@Autowired*/
    public CollectRequestController(CollectRequestService collectRequestService) {
        this.collectRequestService = collectRequestService;
    }

    @GetMapping("/collectRequest")
    public List<CollectRequest> getAllCollectRequests() {
        return collectRequestService.getAll();
    }


    @PostMapping("/collectRequest")
    public String createRequest(@RequestBody CollectRequest collectRequest) {
        collectRequestService.create(collectRequest);
        return "Successful";
    }

    @PutMapping("/collectRequest/{id}")
    public String updateRequest(@PathVariable("id") int id, @RequestBody CollectRequest collectRequest) {

        collectRequestService.edit(collectRequest);
        return "Successful";
    }

    @GetMapping("/collectRequest/{id}")
    public CollectRequest GetAllRequestById(@PathVariable("id") int id) {
        return collectRequestService.findById(id);
    }

    @DeleteMapping("/collectRequest/{id}")
    public String deleteRequestById(@PathVariable("id") int id) {
        collectRequestService.delete(id);
        return "Successful";
    }


}
