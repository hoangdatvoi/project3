<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm tòa nhà</title>
    <!-- Include your CSS files here -->
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <!-- Breadcrumbs -->
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
        </div>

        <!-- Page Content -->
        <div class="page-content">
            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <form:form modelAttribute="buildingEdit" id="listForm" method="GET">
                    <div class="col-xs-12 ">
                        <!-- Form inputs -->
                        <!-- Tên tòa nhà -->
                        <form class="form-horizontal" role="form" id="form-edit"
                        >
                            <div class="form-group">
                                <label class="col-xs-3">Tên tòa nhà</label>
                                <div class="col-xs-9">
                                    <form:input path="name" class="form-control"/>
                                </div>
                            </div>
                            <!-- Quận -->
                            <div class="form-group">
                                <label class="col-xs-3"> Quận</label>
                                <div class="col-xs-9">
                                    <form:select class="form-control" path="district">
                                        <form:option value="">---Chọn Quận---</form:option>
                                        <form:options items="${districts}"/>
                                    </form:select>
                                </div>
                            </div>
                            <!-- Phường -->
                            <div class="form-group">
                                <label class="col-xs-3">Phường</label>
                                <div class="col-xs-9">
                                    <form:input path="ward" class="form-control"/>
                                </div>
                            </div>
                            <!-- Đường -->
                            <div class="form-group">
                                <label class="col-xs-3">Đường</label>
                                <div class="col-xs-9">
                                    <form:input path="street" class="form-control"/>
                                </div>
                            </div>
                            <!-- Kết cấu -->
                            <div class="form-group">
                                <label class="col-xs-3">Kết cấu</label>
                                <div class="col-xs-9">
                                    <form:input path="structure" class="form-control"/>
                                </div>
                            </div>
                            <!-- Số tầng hầm -->
                            <div class="form-group">
                                <label class="col-xs-3">Số tầng hầm</label>
                                <div class="col-xs-9">
                                    <form:input path="numberOfBasement" class="form-control"/>
                                </div>
                            </div>
                            <!-- Diện tích sàn -->
                            <div class="form-group">
                                <label class="col-xs-3">Diện tích sàn</label>
                                <div class="col-xs-9">
                                    <form:input path="floorArea" class="form-control"/>
                                </div>
                            </div>
                            <!-- Hướng -->
                            <div class="form-group">
                                <label class="col-xs-3">Hướng</label>
                                <div class="col-xs-9">
                                    <form:input path="direction" class="form-control"/>
                                </div>
                            </div>
                            <!-- Hạng -->
                            <div class="form-group">
                                <label class="col-xs-3">Hạng</label>
                                <div class="col-xs-9">
                                    <form:input path="level" class="form-control"/>
                                </div>
                            </div>
                            <!-- Diện tích thuê -->
                            <div class="form-group">
                                <label class="col-xs-3">Diện tích thuê</label>
                                <div class="col-xs-9">
                                    <form:input path="rentArea" class="form-control"/>
                                </div>
                            </div>
                            <!-- Gía thuế -->
                            <div class="form-group">
                                <label class="col-xs-3">Gía thuế</label>
                                <div class="col-xs-9">
                                    <form:input path="rentPrice" class="form-control"/>
                                </div>
                            </div>
                            <!-- Mô tả giá -->
                            <div class="form-group">
                                <label class="col-xs-3">Mô tả giá</label>
                                <div class="col-xs-9">
                                    <form:input path="rentPriceDescription" class="form-control"/>
                                </div>
                            </div>
                            <!-- Phí dịch vụ -->
                            <div class="form-group">
                                <label class="col-xs-3">Phí dịch vụ</label>
                                <div class="col-xs-9">
                                    <form:input path="serviceFee" class="form-control"/>
                                </div>
                            </div>
                            <!-- Phí ô tô -->
                            <div class="form-group">
                                <label class="col-xs-3">Phí ô tô</label>
                                <div class="col-xs-9">
                                    <form:input path="carFee" class="form-control"/>
                                </div>
                            </div>
                            <!-- Phí moto -->
                            <div class="form-group">
                                <label class="col-xs-3">Phí moto</label>
                                <div class="col-xs-9">
                                    <form:input path="motoFee" class="form-control"/>
                                </div>
                            </div>
                            <!-- Phí ngoại giờ -->
                            <div class="form-group">
                                <label class="col-xs-3">Phí ngoại giờ</label>
                                <div class="col-xs-9">
                                    <form:input path="overtimeFee" class="form-control"/>
                                </div>
                            </div>
                            <!-- Tiền điện -->
                            <div class="form-group">
                                <label class="col-xs-3">Tiền điện</label>
                                <div class="col-xs-9">
                                    <form:input path="electricityFee" class="form-control"/>
                                </div>
                            </div>
                            <!-- Đặt cọc -->
                            <div class="form-group">
                                <label class="col-xs-3">Đặt cọc</label>
                                <div class="col-xs-9">
                                    <form:input path="deposit" class="form-control"/>
                                </div>
                            </div>
                            <!-- Thanh toán -->
                            <div class="form-group">
                                <label class="col-xs-3">Thanh toán</label>
                                <div class="col-xs-9">
                                    <form:input path="payment" class="form-control"/>
                                </div>
                            </div>
                            <!-- Thời hạn thuê -->
                            <div class="form-group">
                                <label class="col-xs-3">Thời hạn thuê</label>
                                <div class="col-xs-9">
                                    <form:input path="rentTime" class="form-control"/>
                                </div>
                            </div>
                            <!-- Thời gian trang trí -->
                            <div class="form-group">
                                <label class="col-xs-3">Thời gian trang trí</label>
                                <div class="col-xs-9">
                                    <form:input path="decorationTime" class="form-control"/>
                                </div>
                            </div>
                            <!-- Tên quản lý -->
                            <div class="form-group">
                                <label class="col-xs-3">Tên quản lý</label>
                                <div class="col-xs-9">
                                    <form:input path="managerName" class="form-control"/>
                                </div>
                            </div>
                            <!-- Số điện thoại quản lý -->
                            <div class="form-group">
                                <label class="col-xs-3">Số điện thoại quản lý</label>
                                <div class="col-xs-9">
                                    <form:input path="managerPhone" class="form-control"/>
                                </div>
                            </div>
                            <!-- Phí môi giới -->
                            <div class="form-group">
                                <label class="col-xs-3">Phí môi giới</label>
                                <div class="col-xs-9">
                                    <form:input path="brokerageFee" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3 control-label">Loại tòa nhà</label>
                                <div class="col-xs-9">
                                    <form:checkboxes path="typeCode" items="${typeCodes}"/>
                                </div>
                            </div>
                            <!-- Ghi chú -->
                            <div class="form-group">
                                <label class="col-xs-3">Ghi chú</label>
                                <div class="col-xs-9">
                                    <input type="text" id="note" name="note" class="form-control">
                                </div>
                            </div>
                            <!-- Buttons -->
                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${empty buildingEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Thêm
                                            tòa
                                            nhà
                                        </button>
                                        <button type="button" class="btn btn-primary">Hủy thao tác</button>
                                    </c:if>
                                    <c:if test="${ not empty buildingEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Cập
                                            nhật
                                        </button>
                                        <button type="button" class="btn btn-primary">Hủy thao tác</button>
                                    </c:if>
                                </div>
                            </div>
                        </form>
                    </div>
                </form:form>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content-inner -->
</div><!-- /.main-content -->

<!-- Include your JavaScript libraries here -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('#btnAddOrUpdateBuilding').click(function () {
            var data = {};
            var typeCode = [];
            var formData = $('#listForm').serializeArray();

            $.each(formData, function (i, v) {
                if (v.name != 'typeCode') {
                    data[v.name] = v.value;
                } else {
                    typeCode.push(v.value);
                }
            });
            data["typeCode"] = typeCode;
            // Call the API
            $.ajax({
                type: 'POST',
                url: "${buildingAPI}",
                data: JSON.stringify(data),
                contentType: 'application/json',
                dataType: 'json',
                success: function (response) {
                    console.log("success");
                },
                error: function (response) {
                    console.log("error");
                }
            });
        });
    });
</script>
</body>
</html>