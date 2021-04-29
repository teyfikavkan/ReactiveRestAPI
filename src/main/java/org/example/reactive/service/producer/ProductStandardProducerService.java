package org.example.reactive.service.producer;

import org.example.reactive.data.enums.electronic.ElectronicProductCatCodeEnum;
import org.example.reactive.data.enums.sport.SportProductCatCodeEnum;
import org.example.reactive.document.electronic.ElectronicProductDocument;
import org.example.reactive.document.sport.SportProductDocument;
import org.example.reactive.repository.ProductStandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.reactive.constant.ProjectConstants.RECORD_NUMBER;

@Service
@Profile({"Standard","Async"})
public class ProductStandardProducerService implements SmartLifecycle {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    @Autowired
    private ProductStandardRepository productStandardRepository;

    @EventListener(ApplicationStartedEvent.class)
    private void produceSportProduct() {
        IntStream.range(0, RECORD_NUMBER)
                .mapToObj(this::generateSportProductDocument)
                .map(productStandardRepository::save)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @EventListener(ApplicationStartedEvent.class)
    private void produceElectronicProduct() {
        IntStream.range(0, RECORD_NUMBER)
                .mapToObj(this::generateElectronicProductDocument)
                .map(productStandardRepository::save)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private SportProductDocument generateSportProductDocument(int i) {
        return SportProductDocument.builder()
                .productName("Sport Product Name : " + i + "-" + dateFormat.format(Calendar.getInstance().getTime()))
                .sportProductCatCodeEnum(SportProductCatCodeEnum.randomSportProductCatCodeEnum())
                .purchaseDate(new Date())
                .build();
    }

    private ElectronicProductDocument generateElectronicProductDocument(int i) {
        return ElectronicProductDocument.builder()
                .productName("Sport Product Name : " + i + "-" + dateFormat.format(Calendar.getInstance().getTime()))
                .electronicProductCatCodeEnum(ElectronicProductCatCodeEnum.randomElectronicProductCatCodeEnum())
                .purchaseDate(new Date())
                .build();
    }

    @Override
    public void start() {
        productStandardRepository.deleteAll();
        System.out.println("<------------- All Records Deleted In DB ------------->");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
