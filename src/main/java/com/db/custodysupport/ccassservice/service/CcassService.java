package com.db.custodysupport.ccassservice.service;

        import com.db.custodysupport.ccassservice.model.Trade;
        import com.db.custodysupport.ccassservice.model.TradeRequest;
        import org.springframework.stereotype.Service;

@Service
public class CcassService {

    public Trade getTrade(TradeRequest request) {

        return getTrade(request.getClientId());
    }

    public Trade getTrade(String tradeId) {

        return new Trade(tradeId);
    }


}
