package com.pabi.pabiuser.domain.Address;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
@NotNullAddress
public class Address {

  @NotBlank(groups = AddressGroup.class, message = "주소를 입력해 주세요.")
  @ApiModelProperty(value = "주소", example = "경기 성남시 중원구 은이로43번길 20-1")
  private String address;

  @NotBlank(groups = AddressGroup.class, message = "상세주소를 입력해 주세요.")
  @ApiModelProperty(value = "상세주소", example = "201호")
  private String addressEtc;

  @NotBlank(groups = AddressGroup.class, message = "우편번호를 입력해 주세요.")
  @ApiModelProperty(value = "우편번호", example = "13154")
  private String zipcode;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address1 = (Address) o;
    return Objects.equals(address, address1.address)
        && Objects.equals(addressEtc, address1.addressEtc)
        && Objects.equals(zipcode, address1.zipcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, addressEtc, zipcode);
  }

  @Override
  public String toString() {
    return address + " " + addressEtc + " " + zipcode;
  }
}
