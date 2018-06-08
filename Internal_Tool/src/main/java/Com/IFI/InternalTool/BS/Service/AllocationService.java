package Com.IFI.InternalTool.BS.Service;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import Com.IFI.InternalTool.DS.Model.Allocation;
import Com.IFI.InternalTool.DS.Model.AllocationDetail;
import Com.IFI.InternalTool.Security.CurrentUser;
import Com.IFI.InternalTool.Security.UserPrincipal;


public interface AllocationService {
	
	@PreAuthorize("hasRole('LEADER') OR hasRole('ADMIN')")
	boolean createAllocation(final Allocation allocation);
	
	@PreAuthorize("hasRole('LEADER') OR hasRole('ADMIN')")
	boolean deleteByID(final Long allocation_id);

	List<Allocation> getAllocations(final long employee_id,final int page,final int pageSize);
	
	//get allocated of manager
	List<Allocation> getAllocatedofManager(final long employee_id,final int page,final int pageSize);
	
	// find Allocation By Id
	Allocation findById(final long allocation_id);
	
	// search allocation with month or year
	List<Allocation> SearchAllocationWithTime(final int year, final int month, final int page,
			final int pageSize);
	
	// find AllocationByEmPloyeeID
	List<Allocation> findAllocationByEmployeeID(final long employee_id, final int page,
			final int pageSize);
	
	// find AllocationByProjectID
	List<Allocation> findAllocationByProjectID(final long employee_id, final int page,
			final int pageSize);
	
	// save AllocationDetail
	boolean saveAllocationDetail(final AllocationDetail allocationDetail);

}
