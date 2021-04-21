package br.com.rafael.treinamento.controller.ampq;

import br.com.rafael.treinamento.entity.Filme;
import br.com.rafael.treinamento.service.api.FilmeService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class RabbitController {

    @Autowired
    private FilmeService filmeService;

    @Bean
    public Queue MyQueue(){
        return new Queue("FilaRafael", false);
    }

    @RabbitListener(queues = "FilaRafael")
    public void listen(Filme in){
       filmeService.save(in);
    }
}
