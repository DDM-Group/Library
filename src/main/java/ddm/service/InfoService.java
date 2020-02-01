package ddm.service;

import ddm.enums.Category;
import ddm.entity.Info;
import ddm.enums.InfoStatus;
import ddm.exception.FileNotFoundException;
import ddm.repository.InfoRepository;
import ddm.repository.PhotoRepository;
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

    public Info getInfo(int id) throws FileNotFoundException {
        return infoRepository.findById(id).orElseThrow(FileNotFoundException::new);
    }

    public List<Info> getInfoListByCategory(Category category) {
        return infoRepository.findAllByCategory(category);
    }

    public Info createInfo(Info info) {
        info.setStatus(InfoStatus.AVAILABLE);
        return infoRepository.save(info);
    }

    public Info updateInfo(Info newInfo, int id) throws FileNotFoundException {
        Info oldInfo = infoRepository.findById(id).orElseThrow(FileNotFoundException::new);
        oldInfo.setName(newInfo.getName());
        oldInfo.setData(newInfo.getData());
        oldInfo.setPhoto(newInfo.getPhoto());
        return infoRepository.save(oldInfo);
    }

    public int deleteInfo(int id) throws FileNotFoundException {
        Info oldInfo = infoRepository.findById(id).orElseThrow(FileNotFoundException::new);
        oldInfo.setStatus(InfoStatus.DELETED);
        infoRepository.save(oldInfo);
        return id;
    }

}
