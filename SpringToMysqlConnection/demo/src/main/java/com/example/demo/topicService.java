package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class topicService {
  @Autowired
    private topicRepository topicrepository ;

   public List<Topic>topics = new ArrayList<>(Arrays.asList(
            new Topic("java","tazim","CSE student"),
                new Topic("spring","ajoy"," Cse student")
        ));

   public  List<Topic> getalltopic()
    {
        //return topics;
        /*List<Topic>topics = new ArrayList<>();
        topicrepository.findAll()
        .forEach(topics::add);
        return topics;*/
        return (List<Topic>) topicrepository.findAll();

    }
    public Topic gettopic(String Id)
    {
        return topics.stream().filter(topic -> topic.getId().equals(Id)).findFirst().get();
        //return topicrepository.findOne(Id);

    }
    public void addtopic(Topic topic)
    {
        //topics.add(topic);
        topicrepository.save(topic);
    }

    public void updatetopic(String Id, Topic topic) {

       for(int i=0; i<topics.size(); i++)
       {
           Topic t = topics.get(i);
           if(t.getId().equals(Id))
           {
                topics.set(i,topic);
                return;
           }
       }
    }

    public void deletetopic(String Id) {
       topics.removeIf(topic -> topic.getId().equals(Id));
    }
}
