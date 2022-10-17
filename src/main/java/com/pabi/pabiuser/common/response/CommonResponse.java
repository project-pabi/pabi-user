package com.pabi.pabiuser.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

  @ApiModelProperty(example = "성공여부")
  private Result result;
  @ApiModelProperty(example = "응답데이터")
  private T data;
  @ApiModelProperty(example = "메세지")
  private String message;
  @ApiModelProperty(example = "오류 코드")
  private String errorCode;

  public static <T> CommonResponse<T> success(T data, String message) {
    return (CommonResponse<T>) CommonResponse.builder()
        .result(Result.SUCCESS)
        .data(data)
        .message(message)
        .build();
  }

  public static <T> CommonResponse<T> success(T data) {
    return success(data, null);
  }

  public static CommonResponse fail(String message, String errorCode) {
    return CommonResponse.builder()
        .result(Result.FAIL)
        .message(message)
        .errorCode(errorCode)
        .build();
  }

  public static CommonResponse fail(ErrorCode errorCode) {
    return CommonResponse.builder()
        .result(Result.FAIL)
        .message(errorCode.getErrorMsg())
        .errorCode(errorCode.name())
        .build();
  }

  public enum Result {
    SUCCESS, FAIL
  }
}
