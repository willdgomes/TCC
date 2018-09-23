<%-- 
    Document   : page
    Created on : Apr 28, 2018, 10:07:28 PM
    Author     : renannelsen
--%>

<%@tag description="Página Padrão" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.2.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/extras.js"></script>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar sticky-top bg-light">
            <div class="row no-gutters w-100">
                <div class="col">
                    <div class="d-block d-lg-none toggler">
                        <a class="btn" tabindex="0" role="button">
                            <i class="toggler-menu material-icons">menu</i><i class="toggler-clear material-icons d-none">clear</i>
                        </a>
                    </div>
                </div>
                <div class="col-4 col-sm-3 text-center">
                    <a class="navbar-brand" href="#"><div style="width:100px; height:40px;">Sistema Gerenciador de Medicamentos - APPP</div></a>
                </div>
                <div class="col">
                    <div class="d-block d-sm-block">
                        <ul class="nav justify-content-end">
                            <li class="nav-item">
                                <a class="nav-link btn" tabindex="0" role="button" data-toggle="popover" data-placement="bottom" data-html="true" data-content="<div class='popup-box'><div class='header'>notificações <span class='badge badge-secondary'>1</span></div><div class='body'>

                                   <div class='list-group list-group-flush'>
                                   <a href='#' class='list-group-item list-group-item-action active'>
                                   <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                                   <small>Donec id elit non mi porta.</small>
                                   </a>
                                   <a href='#' class='list-group-item list-group-item-action'>
                                   <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                                   <small>Donec id elit non mi porta.</small>
                                   </a>
                                   <a href='#' class='list-group-item list-group-item-action'>
                                   <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                                   <small>Donec id elit non mi porta.</small>
                                   </a>
                                   <a href='#' class='list-group-item list-group-item-action'>
                                   <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                                   <small>Donec id elit non mi porta.</small>
                                   </a>
                                   <a href='#' class='list-group-item list-group-item-action'>
                                   <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                                   <small>Donec id elit non mi porta.</small>
                                   </a>
                                   <a href='#' class='list-group-item list-group-item-action'>
                                   <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                                   <small>Donec id elit non mi porta.</small>
                                   </a>
                                   </div>

                                   </div><div class='footer'><a class='btn btn-light btn-block' href='#' role='button'>ver todas as notificações</a></div></div>"><i class="material-icons red">notifications</i></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn" tabindex="0" role="button" data-toggle="popover" data-placement="bottom" data-html="true" data-content="<div class='popup-box'><div class='header'>Admin<br /><small>administrador</small></div><div class='body'>

                                   <ul class='nav flex-column'>
                                   <li class='nav-item'>
                                   <a class='nav-link' href='#'>minha conta</a>
                                   </li>
                                   <li class='nav-item'>
                                   <a class='nav-link' href='#'>configurações</a>
                                   </li>
                                   </ul>

                                   </div><div class='footer'><a class='btn btn-light btn-block' href='#' role='button'>sair</a></div></div>"><i class="material-icons">account_circle</i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

        <!-- sidebar -->
        <div class="d-flex flex-nowrap">
            <div class="sidebar d-none d-lg-block bg-light">

                <ul class="nav flex-column">
                    <li class="header">menu</li>

                    <li class="nav-item">
                        <a class="nav-link" tabindex="0" data-toggle="collapse" href="#menuCadastro" role="button" aria-expanded="false" aria-controls="menuDashboard"><strong><i class="material-icons">content_paste</i> <span class="align-top">Cadastrar</span><div class="float-right caret"><i class="material-icons">arrow_drop_down</i></div></strong></a>
                        <div class="collapse show" id="menuCadastro">
                            <ul class="nav flex-column">
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="cadastrarPacientes.jsp"><i class="material-icons">person_add</i> <span class="align-top">Pacientes</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="cadastrarRetirante.jsp"><i class="material-icons">group_add</i> <span class="align-top">Retirantes</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="cadastrarMedicamento.jsp"><i class="material-icons">library_add</i> <span class="align-top">Medicamentos</span></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" tabindex="0" data-toggle="collapse" href="#menuGerenciamento" role="button" aria-expanded="false" aria-controls="menuDashboard"><strong><i class="material-icons">content_paste</i><span class="align-top">Gerenciar</span> <div class="float-right caret"><i class="material-icons">arrow_drop_down</i></div></strong></a>
                        <div class="collapse show" id="menuGerenciamento">
                            <ul class="nav flex-column">
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="gerenciarPacientes.jsp"><i class="material-icons">person</i> <span class="align-top">Pacientes</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="gerenciarRetirantes.jsp"><i class="material-icons">group</i> <span class="align-top">Retirantes</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="selecionarRemedioDispensa.jsp"><i class="material-icons">local_pharmacy</i> <span class="align-top">Medicamentos</span></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" tabindex="0" data-toggle="collapse" href="#menuEstoque" role="button" aria-expanded="false" aria-controls="menuDashboard"><strong><i class="material-icons">content_paste</i> <span class="align-top">Estoque</span> <div class="float-right caret"><i class="material-icons">arrow_drop_down</i></div></strong></a>
                        <div class="collapse show" id="menuEstoque">
                            <ul class="nav flex-column">
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="selecionarRemedioDispensa.jsp"><i class="material-icons">indeterminate_check_box</i> <span class="align-top">Dispensar Medicamento</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">add_box</i> <span class="align-top">Inserir Medicamento</span></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" tabindex="0" data-toggle="collapse" href="#menuApps" role="button" aria-expanded="false" aria-controls="menuApps"><strong><i class="material-icons">apps</i> <span class="align-top">Relatórios</span> <div class="float-right caret closed"><i class="material-icons">arrow_drop_down</i></div></strong></a>
                        <div class="collapse" id="menuApps">
                            <ul class="nav flex-column">
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                                <li class="nav-sub-item">
                                    <a class="nav-link" href="#"><i class="material-icons">keyboard_arrow_right</i> <span class="align-top">lorem</span></a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>

            <!-- main -->    
            <jsp:doBody/>
    </body>
</html>
