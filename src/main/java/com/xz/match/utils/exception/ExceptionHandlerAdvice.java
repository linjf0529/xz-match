package com.xz.match.utils.exception;

import com.xz.match.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.regex.Pattern;

/**
 * 使用Advice方式处理异常
 * @author chenwf
 * @date 2020/6/12
 */
@ResponseBody
@ControllerAdvice
public class ExceptionHandlerAdvice {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * Instantiates a new Exception handler advice.
     */
    public ExceptionHandlerAdvice() {
        log.debug("Enabled Exception Handler Advice [启动服务异常处理]");
    }

    /**
     * Handle exception result.
     *
     * @param e the e
     * @return the result
     */
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult handleException(CommonException e) {
        if (e.getErrorClass() != null) {
            final Logger logger = LoggerFactory.getLogger(e.getErrorClass());
            logger.error(e.getMessage(), e);
        } else {
            log.error(e.getMessage(), e);
        }
        return ResponseResult.fail(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * Handle exception result.
     *
     * @param e the e
     * @return the result
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(MissingServletRequestParameterException e) {
        String parameterName = e.getParameterName();
        String parameterType = e.getParameterType();
        log.error("缺少必填参数{} {}", parameterType, parameterName, e);
        return ResponseResult.fail(500, "缺少必填参数:" + parameterName);
    }

    /**
     * Handle exception error result.
     *
     * @param e the e
     * @return the error result
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleException(HttpRequestMethodNotSupportedException e) {
        final String message = e.getMessage();
        log.error(message, e);
        final String[] split = message.split("'");
        if (split.length >= 2) {
            return ResponseResult.fail(500, "请求方式错误"+split[1]);
        }
        return ResponseResult.fail(500, "请求方式错误");
    }

    /**
     * Handle exception error result.
     *
     * @param e the e
     * @return the error result
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(Throwable e) {
        final String message = e.getMessage() != null ? e.getMessage() : e.toString();
        log.error(message, e);
        final String regEx = "[\u4e00-\u9fa5]";
        final Pattern p = Pattern.compile(regEx);
        if (p.matcher(message).find()) {
            return ResponseResult.fail(500, message);
        }
        if (message.contains("timeout") || message.contains("timedout")) {
            return message.contains("refused") ? ResponseResult.fail(500, "服务器拒绝连接")
                    : ResponseResult.fail(500, "服务器拒绝连接");
        }
        return ResponseResult.fail(500, "服务器内部异常");
    }

    /**
     * Handle exception failed result.
     *
     * @param e the e
     * @return the failed result
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseResult.fail(500, this.getBindMessage(e.getMessage()));
    }

    /**
     * No mapping error result.
     *
     * @param e the exception
     * @return the error result
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseResult noMapping(NoHandlerFoundException e) {
        log.error(e.getMessage(), e);
        return ResponseResult.fail(500, "请求路径不存在");
    }

    /**
     * Error param error result.
     *
     * @param me the me
     * @return the error result
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult errorParam(MethodArgumentTypeMismatchException me) {
        log.error(me.getMessage(), me);
        return ResponseResult.fail(500, "请求参数不合法");
    }

    /**
     * Handle HttpMediaTypeNotSupportedException result
     *
     * @param e exception
     * @return the error result
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ResponseResult handleException(HttpMediaTypeNotSupportedException e) {
        final String message = e.getMessage();
        log.error(message, e);
        final String[] split = message.split("'");
        if (split.length >= 2) {
            return ResponseResult.fail(500, "参数文本类型错误"+split[1]);
        }
        return ResponseResult.fail(500, "参数文本类型错误");
    }


    private String getBindMessage(String str) {
        if (StringUtils.hasText(str)) {
            String[] sa = str.split("message");
            if (sa.length > 0) {
                for (int i = sa.length - 1; i >= 0; --i) {
                    if (sa[i].getBytes().length != sa[i].length()) {
                        str = sa[i].trim().replace("[", "");
                        String[] st = str.split("]");
                        if (st.length > 0) {
                            str = st[0];
                        }
                        break;
                    }
                }
            }
        }
        return str;
    }

}
