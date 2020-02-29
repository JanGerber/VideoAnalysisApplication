package de.jangerber.videoanalysis.controllers;

import de.jangerber.videoanalysis.mapper.DeviceMapper;
import de.jangerber.videoanalysis.services.DeviceService;
import de.jangerber.videoanalysis.transfer.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class DeviceController {

    @Autowired
    private DeviceService scheduleService;

    @Autowired
    private DeviceMapper mapper;

    @RequestMapping(value = "/device", method = RequestMethod.GET)
    public List<DeviceDTO> getAllDevices() {
        return scheduleService.getAllDevices().stream().map(schedule -> mapper.entitiyToDto(schedule)).collect(Collectors.toList());
    }


    @RequestMapping(value = "/device", method = RequestMethod.POST)
    public DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO) {
        return mapper.entitiyToDto(scheduleService.createDevice(mapper.dtoToEntitiy(deviceDTO)));
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.DELETE)
    public void deleteDevice(@PathVariable UUID id) {
        scheduleService.deleteDevice(id);
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
    public DeviceDTO getDevice(@PathVariable UUID id) {
        return mapper.entitiyToDto(scheduleService.getDevice(id));
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.PUT)
    public DeviceDTO putDevice(@PathVariable UUID id, @RequestBody DeviceDTO deviceDTO) {
        return mapper.entitiyToDto(scheduleService.updateDevice(mapper.dtoToEntitiy(deviceDTO)));
    }
}
