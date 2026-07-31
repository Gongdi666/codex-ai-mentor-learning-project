package com.example.devsupport.master.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devsupport.master.dto.response.MasterDataResponse;
import com.example.devsupport.master.service.MasterDataService;

@RestController
@RequestMapping("/api/master-data")
public class MasterDataController {
    private final MasterDataService masterDataService;

    // コンストラクタインジェクションでMasterDataServiceを呼び出す
    public MasterDataController(MasterDataService masterDataService) {
        this.masterDataService = masterDataService;
    }

    @GetMapping // このメソッドでGETリクエストを受け、その結果をそのまま返す
    public MasterDataResponse getMasterData() {
        return masterDataService.getMasterData();
    }
}