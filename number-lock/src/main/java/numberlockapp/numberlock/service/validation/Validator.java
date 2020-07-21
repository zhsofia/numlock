package numberlockapp.numberlock.service.validation;

import lombok.NoArgsConstructor;
import numberlockapp.numberlock.NumberLockApplication;
import numberlockapp.numberlock.entity.NumComb;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Component
@NoArgsConstructor
public class Validator {

    public void validateNumComb(NumComb numComb){
        if(numComb.getCombination().size()!=NumberLockApplication.NUM) throw new ValidationException("The combination should contain " + NumberLockApplication.NUM + " numbers");
        for (int i = 0; i < numComb.getCombination().size(); i++) {
           if(numComb.getCombination().get(i)> NumberLockApplication.BASE-1
              || numComb.getCombination().get(i)<0)
               throw new ValidationException("The numbers of the combination should be from 0 to "+(NumberLockApplication.BASE-1));
        }
    }
}
