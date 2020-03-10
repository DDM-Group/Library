package ddm.service;

import ddm.enums.Category;
import ddm.entity.Info;
import ddm.enums.InfoStatus;
import ddm.exception.DataNotFoundException;
import ddm.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public Info getInfo(int id, InfoStatus status) throws DataNotFoundException {
        return infoRepository.findByInfoIdAndStatus(id, status).orElseThrow(DataNotFoundException::new);
    }

    public List<Info> getInfoListByCategory(Category category, InfoStatus status) {
        if (category.equals(Category.ALL)){
            return infoRepository.findAllByStatus(status);
        }
        return infoRepository.findAllByCategoryAndStatus(category, status);
    }

    public Info createInfo(Info info) {
        info.setStatus(InfoStatus.AVAILABLE);
        return infoRepository.save(info);
    }

    public Info updateInfo(Info newInfo, int id) throws DataNotFoundException {
        Info oldInfo = infoRepository.findById(id).orElseThrow(DataNotFoundException::new);
        oldInfo.setName(newInfo.getName());
        oldInfo.setData(newInfo.getData());
        oldInfo.setPhoto(newInfo.getPhoto());
        oldInfo.setStatus(newInfo.getStatus());
        oldInfo.setCategory(newInfo.getCategory());
        return infoRepository.save(oldInfo);
    }

    public int deleteInfo(int id) throws DataNotFoundException {
        Info oldInfo = infoRepository.findById(id).orElseThrow(DataNotFoundException::new);
        oldInfo.setStatus(InfoStatus.DELETED);
        infoRepository.save(oldInfo);
        return id;
    }

}
