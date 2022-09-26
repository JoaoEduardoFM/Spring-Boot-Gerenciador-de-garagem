package ApplicacaoGaragem.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class NotFoundDetails {

	private int status;
	private String detail;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date data;
	}

