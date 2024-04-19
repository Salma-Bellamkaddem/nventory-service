package ma.xproce.nventoryservice;

import ma.xproce.nventoryservice.dao.entites.Creator;
import ma.xproce.nventoryservice.dao.entites.Video;
import ma.xproce.nventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.nventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class NventoryServiceApplication   {


    public static void main(String[] args) {

        SpringApplication.run(NventoryServiceApplication.class, args);
    }
    @Bean
public CommandLineRunner start(CreatorRepository creatorRepository , VideoRepository videoRepository){
        return args -> {
            Creator c1=new Creator(null,"profile1","salma","salma@gmail.com","pass123",null);
            Creator c2=new Creator(null,"profileahmed","ahmed","ahmed@gmail.com","pass14",null);
            Creator c3=new Creator(null,"profilemarwa","marwa","marwa@gmail.com","pass17",null);
creatorRepository.save(c1);
            creatorRepository.save(c2);
            creatorRepository.save(c3);
            List<Creator>creatorList=creatorRepository.findAll();
            creatorList.forEach(p->{
                System.out.println(p.toString());
            });

            Video v1 = new Video( null , "Devops","aaaa/SSSS","description222",new Date(),null);
            Video v2 = new Video( null , "Java","mkk/SSSS","description222",new Date(),null);
            Video v3 = new Video( null , "windows","asss/SSSS","description222",new Date(),null);
            Video v4 = new Video( null , "linux","aaaa/SSSS","description222",new Date(),null);

            videoRepository.save(v1);
            videoRepository.save(v2);
            videoRepository.save(v3);
            videoRepository.save(v4);



        };
}

}
