<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 08.10.2019
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <title>Insert title here</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light"><a class="navbar-brand" href="#">ToDo List</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active"><a class="nav-link" href="logout">LogOut <span
                        class="sr-only">(current)</span></a></li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <div class="row" style="margin-bottom: 10px; margin-top: 10px">
            <div class="col-sm-12">
                <button class="btn btn-primary" data-toggle="modal" data-target="#createModal" onclick="getDate()">
                    <i class="fa fa-plus"></i>Add new item
                </button>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <%--                <th>#</th>--%>
                <th>Title</th>
                <th>Description</th>
                <th>Action</th>
                <th>Date</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="items-list">

            </tbody>
        </table>
    </div>
    <%--    Create Model--%>
    <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="createModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="createModalLabel">Add Item</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="item-name">Item name</label>
                        <input class="form-control" type="text" name="item-name" id="create-item-name" value=""
                               required>
                    </div>
                    <div class="form-group">
                        <label for="item-description">Item description</label>
                        <input class="form-control" type="text" name="item-description" id="create-item-description"
                               value="" required>
                    </div>
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input class="form-control" type="datetime-local" name="date" id="create-date" value=""
                               required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="createItem()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <%--    Create Model--%>

    <%--    Update Model--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Edit Item</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="item-name">Item name</label>
                        <input class="form-control" type="text" name="item-name" id="item-name" value="" required>
                    </div>
                    <div class="form-group">
                        <label for="item-description">Item description</label>
                        <input class="form-control" type="text" name="item-description" id="item-description" value=""
                               required>
                    </div>
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input class="form-control" type="datetime-local" name="date" id="date" value="" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="updateItem()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <%--    Update Model--%>

</main>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script>
    var items = [];
    var selectedId = null;

    $(document).ready(function () {
        init();
    });

    function init() {
        items = [];
        $.get("items", function (data) {
            items = JSON.parse(data);
            fillTable(items);
        });
    }

    function fillTable(items) {
        $('#items-list').html('');
        for (var item of items) {
            item.action = getAction(item.time);
            $('#items-list').append(createRow(item));
        }
    }

    function createRow(item) {
        var row = $('<tr></tr>');
        if(item.action === 'Expired') {
            row = $('<tr style="color: red"></tr>');
        }
        row.append(createTd(item.title));
        row.append(createTd(item.description));
        row.append(createTd(item.action));
        row.append(createTd(parseDate(item.time, '/')));
        row.append(createEditButton(item.id));
        row.append(createDeleteButton(item.id));
        return row;
    }

    function createTd(text) {
        var td = $('<td></td>');
        td.append(text);
        return td;
    }

    function createEditButton(id) {
        var button = $('<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-pencil"></i>Edit</button>');
        button.click(function () {
            var item = items.find(item=>item.id == id);
            $('#item-name').val(item.title);
            $('#item-description').val(item.description);
            $('#date').val(parseDate(item.time, '-'));
            selectedId = id;
        });
        var td = $('<td></td>');
        td.append(button);
        return td;
    }

    function createDeleteButton(id) {
        var button = $('<button type="button" class="btn btn-danger">Delete</button>');
        button.click(function () {
            $.ajax({
                    url: '/SoftServe_war_exploded/item/delete/' + id,
                    type: 'delete',
                    cache: false,
                    success: function () {
                        document.location.reload();
                    },
                    error: function () {
                        alert('error');
                    }
                }
            )
        });
        var td = $('<td></td>');
        td.append(button);
        return td;
    }

    function updateItem() {
        $.ajax({
                url: 'item/update',
                data: {
                    id: selectedId,
                    title: $('#item-name').val(),
                    description: $('#item-description').val(),
                    action: 'default',
                    datetime: $('#date').val()
                },
                type: 'post',
                cache: false,
                success: function () {
                    $('#exampleModal').modal('hide');
                    document.location.reload();
                },
                error: function () {
                    alert('error');
                }
            }
        )
    }

    function createItem() {
        $.ajax({
                url: 'item/create',
                data: {
                    title: $('#create-item-name').val(),
                    description: $('#create-item-description').val(),
                    action: 'default',
                    datetime: $('#create-date').val()
                },
                type: 'post',
                cache: false,
                success: function () {
                    $('#createModal').modal('hide');
                    document.location.reload();
                },
                error: function () {
                    alert('error');
                }
            }
        )
    }

    function getDate() {
        var now = new Date();
        var utcString = now.toISOString().substring(0, 19);
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        var day = now.getDate() + 1;
        var hour = now.getHours();
        var minute = now.getMinutes();
        var second = now.getSeconds();
        var localDatetime = year + "-" +
            (month < 10 ? "0" + month.toString() : month) + "-" +
            (day < 10 ? "0" + day.toString() : day) + "T" +
            (hour < 10 ? "0" + hour.toString() : hour) + ":" +
            (minute < 10 ? "0" + minute.toString() : minute) +
            utcString.substring(16, 19);
        var datetimeField = document.getElementById("create-date");
        datetimeField.value = localDatetime;
    }
    function parseDate(itemDate, settings) {
        var date;
        if (settings === '-') {
            date = itemDate.date.year + '-' + itemDate.date.month + '-' + itemDate.date.day + 'T' + itemDate.time.hour + ':' + itemDate.time.minute;
        } else if (settings === '/') {
            date = itemDate.date.year + '/' + itemDate.date.month + '/' + itemDate.date.day + ' ' + itemDate.time.hour + ':' + itemDate.time.minute;
        }
        // else if (settings == 'todayDate') {
        //     date = itemDate.date.year + '-' + itemDate.date.month + '-' + itemDate.date.day;
        // }
        return date;
    }

    function getTodayDate() {
        var today = new Date().toISOString();
        var json = {
            'date': {
                'year': Number(today.substring(0, 4)),
                'month': Number(today.substring(5, 7)),
                'day': Number(today.substring(8, 10))
            }
        };
        return json;
    }

    function getAction(itemDate) {
        var text = ['Expired', 'Today', 'Tomorrow', 'Upcoming'];
        if ((itemDate.date.year < getTodayDate().date.year) ||
            (itemDate.date.year === getTodayDate().date.year &&
                itemDate.date.month < getTodayDate().date.month) ||
            (itemDate.date.year === getTodayDate().date.year &&
                itemDate.date.month === getTodayDate().date.month &&
                itemDate.date.day < getTodayDate().date.day)) {
            return text[0];
        } else if ((itemDate.date.year === getTodayDate().date.year) &&
            (itemDate.date.month === getTodayDate().date.month) &&
            (itemDate.date.day === getTodayDate().date.day)) {
            return text[1];
        } else if((itemDate.date.year === getTodayDate().date.year)&&
            (itemDate.date.month === getTodayDate().date.month)&&
            (itemDate.date.day === getTodayDate().date.day+1)){
            return text[2];
        } else {
            return text[3];
        }
    }

</script>
</html>
