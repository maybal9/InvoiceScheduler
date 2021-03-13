package maayan.InvoiceScheduler.Service;

import org.springframework.stereotype.Service;

@Service
public class RiskService {
    public int risk_score;

    public boolean validateRisk(float amount) {
        return amount <= 20000 || risk_score > 90;
    }
}
