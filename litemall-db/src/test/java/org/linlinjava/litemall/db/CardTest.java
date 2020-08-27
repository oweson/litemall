package org.linlinjava.litemall.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.linlinjava.litemall.db.dao.LitemallCardMapper;
import org.linlinjava.litemall.db.domain.LitemallCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class CardTest {
    @Autowired
    LitemallCardMapper litemallCardMapper;

    @Test
    public void saveOne() {
        LitemallCard litemallCard = new LitemallCard();
        //litemallCard.setId(0L);
        litemallCard.setCode("412724");
        litemallCard.setCountry("china");
        litemallCardMapper.insert(litemallCard);

    }

    @Test
    public void batchInsert() {
        List<LitemallCard> litemallCards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            LitemallCard litemallCard = new LitemallCard();
            litemallCard.setCode("" + i);
            litemallCard.setCountry("china");
            litemallCards.add(litemallCard);

        }
        litemallCardMapper.batchSaveCard(litemallCards);
        litemallCards.stream().forEach(System.out::println);

    }

    @Test
    public void batchUpdateCard() {
        List<LitemallCard> litemallCards = litemallCardMapper.selectByExample(null);
        litemallCards.stream().forEach(e -> {
            e.setCountry("theusa");
        });
        System.out.println(litemallCardMapper.batchUpdateCard(litemallCards));
    }
}
