package com.xcphoenix.dto.bean.dto;

import com.xcphoenix.dto.bean.dao.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author      xuanc
 * @date        2019/8/16 下午11:02
 * @version     1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foods {

    private Long categoryId;
    private String categoryName;
    List<Food> foodsDetail;

}

