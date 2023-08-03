package cordelia.rpc;

import java.util.List;

import cordelia.rpc.types.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class RsGroupGet implements RsArguments {

    private List<Group> group;

}
