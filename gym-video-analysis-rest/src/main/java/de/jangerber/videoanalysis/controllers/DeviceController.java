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
    private DeviceService deviceService;

    @Autowired
    private DeviceMapper mapper;

    @RequestMapping(value = "/device", method = RequestMethod.GET)
    public List<DeviceDTO> getAllDevices() {
        return deviceService.getAllDevices().stream().map(schedule -> mapper.entityToDto(schedule)).collect(Collectors.toList());
    }


    @RequestMapping(value = "/device", method = RequestMethod.POST)
    public DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO) {
        return mapper.entityToDto(deviceService.createDevice(mapper.dtoToEntity(deviceDTO)));
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.DELETE)
    public void deleteDevice(@PathVariable UUID id) {
        deviceService.deleteDevice(id);
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
    public DeviceDTO getDevice(@PathVariable UUID id) {
        return mapper.entityToDto(deviceService.getDevice(id));
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.PUT)
    public DeviceDTO putDevice(@PathVariable UUID id, @RequestBody DeviceDTO deviceDTO) {
        return mapper.entityToDto(deviceService.updateDevice(mapper.dtoToEntity(deviceDTO)));
    }
}
