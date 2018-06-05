package Com.IFI.InternalTool.DS.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import Com.IFI.InternalTool.DS.Model.Group_IFI;


public interface Group_IFIDAO {


	
	Group_IFI createGroup(final Group_IFI group);

	Group_IFI findGroupById(final String group_id);

	List<Group_IFI> findGroupNameLike(final String name,final int page,final int pageSize);
	
	List<Group_IFI> getGroups(final int page,final int pageSize);

	Boolean deleteGroupById(final String groupId);
	
	
	
}
